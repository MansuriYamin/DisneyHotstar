package com.ymistudios.disneyhotstar.data.pagination

interface Paginator<Key, Item> {

    suspend fun loadNextItems()
    fun reset()
}