package com.ymistudios.disneyhotstar.data.pojo.movie

data class Header(
    val header: String,
    val type: Type
) {
    enum class Type {
        FOR_YOU,
        CONTINUE_WATCHING,
        POPULAR,
        FOR_KIDS,
        TRENDING
    }
}
