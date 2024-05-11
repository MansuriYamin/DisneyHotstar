package com.ymistudios.disneyhotstar.data.database

import com.ymistudios.disneyhotstar.data.pojo.movie.Header
import com.ymistudios.disneyhotstar.data.pojo.movie.Movie
import com.ymistudios.disneyhotstar.data.pojo.movie.Trailer

object MovieDatabase {

    val headers = listOf(
        Header(header = "For You", type = Header.Type.FOR_YOU),
        Header(header = "Popular", type = Header.Type.POPULAR),
        Header(header = "Continue Watching", type = Header.Type.CONTINUE_WATCHING),
        Header(header = "Trending", type = Header.Type.TRENDING),
    )

    val movieList = listOf(
        Movie(
            id = 1,
            title = "Zootopia",
            description = "In a city of anthropomorphic animals, a bunny cop and a cynical con artist fox must work together to uncover a conspiracy.",
            year = 2016,
            genre = listOf("Animation", "Adventure", "Comedy"),
            durationMinutes = 108,
            imdbRating = 8.0,
            posterUrl = "https://i.pinimg.com/736x/c0/89/7a/c0897a72abc0221eb67a99d744eaecf5.jpg",
            trailer = listOf(Trailer(1, "https://example.com/zootopia_trailer.mp4", 120)),
            parentalRating = "PG"
        ),
        Movie(
            id = 2,
            title = "Cars",
            description = "A hot-shot race-car named Lightning McQueen gets waylaid in Radiator Springs, where he finds the true meaning of friendship and family.",
            year = 2006,
            genre = listOf("Animation", "Adventure", "Comedy"),
            durationMinutes = 117,
            imdbRating = 7.1,
            posterUrl = "https://i.pinimg.com/736x/c6/ac/ed/c6aced5d39018cc4ce37ed055629afbf.jpg",
            trailer = listOf(Trailer(2, "https://example.com/cars_trailer.mp4", 110)),
            parentalRating = "G"
        ),
        Movie(
            id = 3,
            title = "Toy Story",
            description = "A cowboy doll is profoundly threatened and jealous when a new spaceman figure supplants him as top toy in a boy's room.",
            year = 1995,
            genre = listOf("Animation", "Adventure", "Comedy"),
            durationMinutes = 81,
            imdbRating = 8.3,
            posterUrl = "https://i.pinimg.com/736x/aa/39/57/aa39574b40081259b8b674dcc78c86d3.jpg",
            trailer = listOf(Trailer(3, "https://example.com/toy_story_trailer.mp4", 95)),
            parentalRating = "G"
        ),
        Movie(
            id = 4,
            title = "Finding Nemo",
            description = "After his son is captured in the Great Barrier Reef and taken to Sydney, a timid clownfish sets out on a journey to bring him home.",
            year = 2003,
            genre = listOf("Animation", "Adventure", "Comedy"),
            durationMinutes = 100,
            imdbRating = 8.1,
            posterUrl = "https://i.pinimg.com/736x/93/6d/de/936dde7cea710e5a3c8ab01e21c7a846.jpg",
            trailer = listOf(Trailer(4, "https://example.com/finding_nemo_trailer.mp4", 120)),
            parentalRating = "G"
        ),
        Movie(
            id = 5,
            title = "The Lion King",
            description = "Lion prince Simba and his father are targeted by his bitter uncle, who wants to ascend the throne himself.",
            year = 1994,
            genre = listOf("Animation", "Adventure", "Drama"),
            durationMinutes = 89,
            imdbRating = 8.5,
            posterUrl = "https://i.pinimg.com/736x/d3/4a/e0/d34ae00081e8a203e1acfd360f0ae7f4.jpg",
            trailer = listOf(Trailer(5, "https://example.com/lion_king_trailer.mp4", 90)),
            parentalRating = "G"
        ),
        Movie(
            id = 6,
            title = "Moana",
            description = "In Ancient Polynesia, when a terrible curse incurred by the Demigod Maui reaches Moana's island, she answers the Ocean's call to seek out the Demigod to set things right.",
            year = 2016,
            genre = listOf("Animation", "Adventure", "Comedy"),
            durationMinutes = 107,
            imdbRating = 7.6,
            posterUrl = "https://i.pinimg.com/736x/bf/0f/53/bf0f539e1d82d62725911e2b75056f46.jpg",
            trailer = listOf(Trailer(6, "https://example.com/moana_trailer.mp4", 110)),
            parentalRating = "PG"
        ),
        Movie(
            id = 7,
            title = "Frozen",
            description = "When the newly-crowned Queen Elsa accidentally uses her power to turn things into ice to curse her home in infinite winter, her sister Anna teams up with a mountain man, his playful reindeer, and a snowman to change the weather condition.",
            year = 2013,
            genre = listOf("Animation", "Adventure", "Comedy"),
            durationMinutes = 102,
            imdbRating = 7.4,
            posterUrl = "https://i.pinimg.com/736x/fe/e6/a6/fee6a6f69e83c4eb9dfce93929c8ad2c.jpg",
            trailer = listOf(Trailer(7, "https://example.com/frozen_trailer.mp4", 120)),
            parentalRating = "PG"
        ),
        Movie(
            id = 8,
            title = "Beauty and the Beast",
            description = "A prince cursed to spend his days as a hideous monster sets out to regain his humanity by earning a young woman's love.",
            year = 1991,
            genre = listOf("Animation", "Family", "Fantasy"),
            durationMinutes = 84,
            imdbRating = 8.0,
            posterUrl = "https://i.pinimg.com/736x/ae/1d/19/ae1d19b2368a16420ac1b864f4e9d6cd.jpg",
            trailer = listOf(
                Trailer(
                    8,
                    "https://example.com/beauty_and_the_beast_trailer.mp4",
                    100
                )
            ),
            parentalRating = "G"
        ),
        Movie(
            id = 9,
            title = "Aladdin",
            description = "A kindhearted street urchin and a power-hungry Grand Vizier vie for a magic lamp that has the power to make their deepest wishes come true.",
            year = 1992,
            genre = listOf("Animation", "Adventure", "Comedy"),
            durationMinutes = 90,
            imdbRating = 8.0,
            posterUrl = "https://i.pinimg.com/736x/a5/08/6b/a5086bb6940abc2d6301e7b1acc1aa6e.jpg",
            trailer = listOf(Trailer(9, "https://example.com/aladdin_trailer.mp4", 105)),
            parentalRating = "G"
        ),
        Movie(
            id = 10,
            title = "The Little Mermaid",
            description = "A mermaid princess makes a Faustian bargain in an attempt to become human and win a prince's love.",
            year = 1989,
            genre = listOf("Animation", "Family", "Fantasy"),
            durationMinutes = 83,
            imdbRating = 7.6,
            posterUrl = "https://i.pinimg.com/736x/23/75/4b/23754b0b1fc5d35c1ee3159ae7cf6acc.jpg",
            trailer = listOf(Trailer(10, "https://example.com/little_mermaid_trailer.mp4", 95)),
            parentalRating = "G"
        )
    )
}