package com.ymistudios.disneyhotstar.data.pojo.movie

data class Movie(
    val id: Int,
    val title: String,
    val description: String,
    val year: Int,
    val genre: List<String>,
    val durationMinutes: Int,
    val imdbRating: Double,
    val posterUrl: String,
    val trailer: List<Trailer>,
    val parentalRating: String
)

data class Trailer(
    val id: Int,
    val trailerUrl: String,
    val durationMinutes: Int
)