package com.ymistudios.disneyhotstar.data.pagination

class DefaultPaginator<Key, Item>(
    private val initialKey: Key,
    private inline val onLoadUpdated: (Boolean) -> Unit,
    private inline val onRequest: suspend (nextKey: Key) -> com.ymistudios.disneyhotstar.data.Response<List<Item>>,
    private inline val getNextKey: (List<Item>) -> Key,
    private inline val onError: suspend (Throwable?) -> Unit,
    private inline val onSuccess: suspend (items: List<Item>, newKey: Key) -> Unit
) : Paginator<Key, Item> {

    private var currentKey = initialKey
    private var isMakingRequest = false

    override suspend fun loadNextItems() {
        if (isMakingRequest)
            return

        isMakingRequest = true
        onLoadUpdated(true)
        val result = onRequest(currentKey)
        isMakingRequest = false
        when (result) {
            is com.ymistudios.disneyhotstar.data.Response.Success -> {
                val items = result.data
                currentKey = getNextKey(items)
                onSuccess(items, currentKey)
                onLoadUpdated(false)
            }

            is com.ymistudios.disneyhotstar.data.Response.Error -> {
                onError(result.error)
                onLoadUpdated(false)
                return
            }
        }
    }

    override fun reset() {
        currentKey = initialKey
    }
}