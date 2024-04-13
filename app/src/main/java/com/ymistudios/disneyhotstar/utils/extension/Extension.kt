package com.ymistudios.disneyhotstar.utils.extension

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController

@Composable
fun <T> NavController.getResult(key: String): T? {
    val savedStateHandle = currentBackStackEntry?.savedStateHandle
    val result = savedStateHandle?.getLiveData<T>(key)?.observeAsState()

    return result?.value?.also {
        savedStateHandle.remove<T>(key)
    }
}
