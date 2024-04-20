package com.ymistudios.disneyhotstar.ui.home

sealed class HomeEvent {

    data object GetMovieList : HomeEvent()
}