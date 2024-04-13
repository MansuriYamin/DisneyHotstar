package com.ymistudios.disneyhotstar.ui

import androidx.lifecycle.ViewModel
import com.ymistudios.disneyhotstar.domain.navigator.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val navigator: Navigator
) : ViewModel() {

    val navigationActionFlow = navigator.navigationActionFlow

    fun navigateBack() {
        navigator.navigateBack()
    }
}