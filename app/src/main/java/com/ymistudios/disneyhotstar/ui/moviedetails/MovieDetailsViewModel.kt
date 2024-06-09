package com.ymistudios.disneyhotstar.ui.moviedetails

import androidx.lifecycle.ViewModel
import com.ymistudios.disneyhotstar.data.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(MovieDetailsUiState())
    val uiState = _uiState.asStateFlow()

    fun onEvent(event: MovieDetailsEvent) {
        when (event) {
            is MovieDetailsEvent.GetMovieDetails -> getMovieDetails(event.id)
            MovieDetailsEvent.GetSimilarMovies -> {

            }
        }
    }

    private fun getMovieDetails(id: Int) {
        _uiState.update {
            it.copy(movie = movieRepository.getMovieDetails(id))
        }
        getSimilarMovies(id)
    }

    private fun getSimilarMovies(id: Int) {
        _uiState.update {
            it.copy(similarMovies = movieRepository.getSimilarMovies(id))
        }
    }
}