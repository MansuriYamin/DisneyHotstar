package com.ymistudios.disneyhotstar.ui.moviedetails

import androidx.lifecycle.ViewModel
import com.ymistudios.disneyhotstar.data.datasource.MovieDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val movieDataSource: MovieDataSource
) : ViewModel() {

    private val _uiState = MutableStateFlow(MovieDetailsUiState())
    val uiState = _uiState.asStateFlow()

    fun onEvent(event: MovieDetailsEvent) {
        when (event) {
            is MovieDetailsEvent.GetMovieDetails -> getMovieDetails(event.id)
        }
    }

    private fun getMovieDetails(id: Int) {
        _uiState.update {
            it.copy(movie = movieDataSource.getMovieDetails(id))
        }
    }
}