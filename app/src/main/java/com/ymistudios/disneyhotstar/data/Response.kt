package com.ymistudios.disneyhotstar.data

sealed class Response<T> {
    data class Success<T>(val data: T) : com.ymistudios.disneyhotstar.data.Response<T>()
    data class Error<T>(val error: Throwable?) : com.ymistudios.disneyhotstar.data.Response<T>()
}
