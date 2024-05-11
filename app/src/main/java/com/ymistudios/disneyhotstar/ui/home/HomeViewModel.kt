package com.ymistudios.disneyhotstar.ui.home

import androidx.lifecycle.ViewModel
import com.ymistudios.disneyhotstar.data.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getMovieList()
    }

    private fun getMovieList() {
        _uiState.update {
            it.copy(movieList = movieRepository.getMovies())
        }
    }
}