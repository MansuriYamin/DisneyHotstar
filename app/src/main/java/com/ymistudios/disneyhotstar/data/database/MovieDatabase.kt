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
            description = "When Judy Hopps, a rookie officer in the Zootopia Police Department, sniffs out a sinister plot, she enlists the help of a con artist to solve the case in order to prove her abilities to Chief Bogo.",
            year = 2016,
            genre = listOf("Family", "Adventure", "Comedy", "Mystery"),
            duration = "1h 48 min",
            imdbRating = 8.0,
            poster = "https://i.pinimg.com/736x/aa/39/57/aa39574b40081259b8b674dcc78c86d3.jpg",
            trailer = listOf(Trailer(1, "https://example.com/zootopia_trailer.mp4", 120)),
            parentalRating = "PG"
        ),
        Movie(
            id = 2,
            title = "Cars 3",
            description = "After the race at the Piston Cup Championship ends in a three-way tie-breaker, a rookie Lightning McQueen is desperate to make it to the winning position and take over the veteran Strip Weathers.",
            year = 2017,
            genre = listOf("Family", "Sport"),
            duration = "1h 42min",
            imdbRating = 6.7,
            poster = "https://i.pinimg.com/564x/06/e2/f4/06e2f4dbd0408c4628de070599041792.jpg",
            trailer = listOf(Trailer(2, "https://example.com/cars_trailer.mp4", 110)),
            parentalRating = "G"
        ),
        Movie(
            id = 3,
            title = "Toy Story",
            description = "Andy's favourite toy, Woody, is worried that after Andy receives his birthday gift, a new toy called Buzz Lightyear, his importance may get reduced. He thus hatches a plan to eliminate Buzz.",
            year = 1995,
            genre = listOf("Family", "Comedy", "Fantasy"),
            duration = "1h 21min",
            imdbRating = 8.3,
            poster = "https://i.pinimg.com/736x/8e/bd/48/8ebd48f66f760c1066bb7f82204d8866.jpg",
            trailer = listOf(Trailer(3, "https://example.com/toy_story_trailer.mp4", 95)),
            parentalRating = "G"
        ),
        Movie(
            id = 4,
            title = "Finding Nemo",
            description = "After his son is captured in the Great Barrier Reef and taken to Sydney, a timid clownfish sets out on a journey to bring him home.",
            year = 2003,
            genre = listOf("Family", "Adventure", "Comedy"),
            duration = "1h 40min",
            imdbRating = 8.2,
            poster = "https://i.pinimg.com/736x/32/9a/8e/329a8ef32824895d65ff6217cec83632.jpg",
            trailer = listOf(Trailer(4, "https://example.com/finding_nemo_trailer.mp4", 120)),
            parentalRating = "G"
        ),
        Movie(
            id = 5,
            title = "The Lion King",
            description = "Simba, a young lion prince, flees his kingdom after the murder of his father, Mufasa. Years later, a chance encounter with Nala, a lioness, causes him to return and take back what is rightfully his.",
            year = 2019,
            genre = listOf("Family", "Adventure", "Musical"),
            duration = "1h 58min",
            imdbRating = 6.8,
            poster = "https://i.pinimg.com/736x/29/48/c6/2948c6b3e59b7d64df4692b7a3e20e20.jpg",
            trailer = listOf(Trailer(5, "https://example.com/lion_king_trailer.mp4", 90)),
            parentalRating = "PG"
        ),
        Movie(
            id = 6,
            title = "Moana",
            description = "Moana, daughter of chief Tui, embarks on a journey to return the heart of goddess Te Fitti from Maui, a demigod, after the plants and the fish on her island start dying due to a blight.",
            year = 2016,
            genre = listOf("Family", "Adventure"),
            duration = "1h 47min",
            imdbRating = 7.6,
            poster = "https://i.pinimg.com/736x/01/55/21/0155216e6895c6e6efde9b30b597554c.jpg",
            trailer = listOf(Trailer(6, "https://example.com/moana_trailer.mp4", 110)),
            parentalRating = "PG"
        ),
        Movie(
            id = 7,
            title = "Frozen",
            description = "Snow Queen Elsa inadvertently uses her power to make her kingdom experience constant wintriness. Her sister Anna teams up with mountaineer Kristoff and his reindeer to demolish the snowy spell.",
            year = 2013,
            genre = listOf("Family", "Musical"),
            duration = "1h 42min",
            imdbRating = 7.4,
            poster = "https://i.pinimg.com/736x/87/1a/ee/871aee026d4c63588282f33ab00ada4a.jpg",
            trailer = listOf(Trailer(7, "https://example.com/frozen_trailer.mp4", 120)),
            parentalRating = "PG"
        ),
        Movie(
            id = 8,
            title = "Onward",
            description = "In a magical world full of technological advances, two elven brothers, Ian and Barley Lightfoot, set out to resurrect their deceased father for a day.",
            year = 2020,
            genre = listOf("Family", "Fantasy"),
            duration = "1h 42m",
            imdbRating = 7.4,
            poster = "https://i.pinimg.com/736x/23/75/4b/23754b0b1fc5d35c1ee3159ae7cf6acc.jpg",
            trailer = listOf(
                Trailer(
                    8,
                    "https://example.com/beauty_and_the_beast_trailer.mp4",
                    100
                )
            ),
            parentalRating = "PG"
        ),
        Movie(
            id = 9,
            title = "Ratatouille",
            description = "Remy, a rat, aspires to become a renowned French chef. However, he fails to realise that people despise rodents and will never enjoy a meal cooked by him.",
            year = 2007,
            genre = listOf("Family", "Comedy", "Fantasy"),
            duration = "1h 51min",
            imdbRating = 8.1,
            poster = "https://i.pinimg.com/736x/ad/13/20/ad13206fb7b7b05541b3bc2a7281fd2f.jpg",
            trailer = listOf(Trailer(9, "https://example.com/aladdin_trailer.mp4", 105)),
            parentalRating = "G"
        ),
        Movie(
            id = 10,
            title = "Finding Dory",
            description = "With vague memories of her past, an amnesiac blue tang fish, Dory, sets off in search of her long-lost parents with the help of her friends, clownfish Marlin and his son Nemo.",
            year = 2016,
            genre = listOf("Family", "Adventure", "Comedy"),
            duration = "1h 37min",
            imdbRating = 7.2,
            poster = "https://i.pinimg.com/736x/56/a9/dc/56a9dc6327e936c08b049f43f90a14b8.jpg",
            trailer = listOf(Trailer(10, "https://example.com/little_mermaid_trailer.mp4", 95)),
            parentalRating = "G"
        ),
        Movie(
            id = 11,
            title = "Wish",
            description = "Young Asha makes a wish so powerful that it's answered by a cosmic force, a little ball of boundless energy called Star. With Star's help, Asha must save her kingdom from King Magnifico and prove that when the will of one courageous human connects with the magic of the stars, wondrous things can happen.",
            year = 2023,
            genre = listOf("Family", "Fantasy"),
            duration = "1h 42min",
            imdbRating = 5.6,
            poster = "https://i.pinimg.com/736x/9c/c8/bc/9cc8bc35430dc70445f6ac6ccc9463ad.jpg",
            trailer = listOf(Trailer(10, "https://example.com/little_mermaid_trailer.mp4", 95)),
            parentalRating = "PG"
        ),
        Movie(
            id = 12,
            title = "Kung Fu Panda 4",
            description = "Po must train a new warrior when he's chosen to become the spiritual leader of the Valley of Peace. However, when a powerful shape-shifting sorceress sets her eyes on his Staff of Wisdom, he suddenly realizes he's going to need some help. Teaming up with a quick-witted corsac fox, Po soon discovers that heroes can be found in the most unexpected places.",
            year = 2024,
            genre = listOf("Comedy", "Adventure"),
            duration = "1h 34min",
            imdbRating = 6.3,
            poster = "https://i.pinimg.com/736x/fc/41/5d/fc415d3e447f60a8829045bef1866ba9.jpg",
            trailer = listOf(Trailer(10, "https://example.com/little_mermaid_trailer.mp4", 95)),
            parentalRating = "PG"
        ),
        Movie(
            id = 13,
            title = "High School Musical",
            description = "Two high school students, who are poles apart, secretly decide to audition for their school's musical. Their talent challenges the elite and turns their world upside down.",
            year = 2006,
            genre = listOf("Musical", "Romance"),
            duration = "1h 38min",
            imdbRating = 5.6,
            poster = "https://i.pinimg.com/736x/e6/ef/20/e6ef20655a2202afff1a5fed2ba4bf1b.jpg",
            trailer = listOf(Trailer(10, "https://example.com/little_mermaid_trailer.mp4", 95)),
            parentalRating = "G"
        ),
        Movie(
            id = 14,
            title = "Stargirl",
            description = "Leo is an average student at school and is also a member of the marching band. However, his mundane life changes when Stargirl, a confident and charming student, enters the school.",
            year = 2020,
            genre = listOf("Musical", "Romance"),
            duration = "1h 47min",
            imdbRating = 6.2,
            poster = "https://i.pinimg.com/736x/4e/5a/0a/4e5a0a572b3a8699dcf428abd8a5a126.jpg",
            trailer = listOf(Trailer(10, "https://example.com/little_mermaid_trailer.mp4", 95)),
            parentalRating = "PG"
        ),
        Movie(
            id = 15,
            title = "The Slumber Party",
            description = "Depicting the aftermath of a sleepover birthday party hypnotism gone wrong as best friends Megan and Paige, along with soon-to-be step-sister Veronica, wake up with absolutely no memory of the night before.",
            year = 2023,
            genre = listOf("Comedy"),
            duration = "1h 47min",
            imdbRating = 5.5,
            poster = "https://i.pinimg.com/736x/ad/f8/7e/adf87e067fb0d9a50c1c68eab89979d9.jpg",
            trailer = listOf(Trailer(10, "https://example.com/little_mermaid_trailer.mp4", 95)),
            parentalRating = "PG"
        ),
        Movie(
            id = 16,
            title = "Prom Pact",
            description = "It is the height of prom season, but high school senior Mandy Yang has her sights set on a singular goal: attending Harvard. When she finds out she has been deferred, she is determined to do whatever she can to get herself off the waitlist, even if that means asking the one person who represents everything she abhors, all-star jock Graham Lansing, whose father is a powerful senator and Harvard alum.",
            year = 2023,
            genre = listOf("Comedy", "Romance", "Melodrama"),
            duration = "1h 47min",
            imdbRating = 6.4,
            poster = "https://i.pinimg.com/736x/27/03/16/270316465a9bee83539d49eb30a70a14.jpg",
            trailer = listOf(Trailer(10, "https://example.com/little_mermaid_trailer.mp4", 95)),
            parentalRating = "PG"
        ),
        Movie(
            id = 17,
            title = "Aladdin",
            description = "Aladdin, a kind thief, woos Jasmine, the princess of Agrabah, with the help of Genie. When Jafar, the grand vizier, tries to usurp the king, Jasmine, Aladdin and Genie must stop him from succeeding.",
            year = 2019,
            genre = listOf("Fantasy", "Musical"),
            duration = "2h 8min",
            imdbRating = 6.9,
            poster = "https://i.pinimg.com/736x/0f/2d/e8/0f2de8abd7453f5f462026912afbac20.jpg",
            trailer = listOf(Trailer(10, "https://example.com/little_mermaid_trailer.mp4", 95)),
            parentalRating = "PG"
        ),
        Movie(
            id = 18,
            title = "The Royal Treatment",
            description = "New York hairdresser Izzy seizes the chance to work at the wedding of a charming prince. When sparks start to fly between the two of them, love and duty are put to the test as the time of the wedding draws closer.",
            year = 2022,
            genre = listOf("Romance", "Comedy"),
            duration = "1h 37min",
            imdbRating = 9.5,
            poster = "https://i.pinimg.com/736x/68/a9/73/68a973a0f286f4b3c0d3a46493333ff1.jpg",
            trailer = listOf(Trailer(10, "https://example.com/little_mermaid_trailer.mp4", 95)),
            parentalRating = "PG"
        ),
        Movie(
            id = 19,
            title = "The Jungle Book",
            description = "Mowgli is a boy brought up in the jungle by a pack of wolves. When Shere Khan, a tiger, threatens to kill him, a panther and a bear help him escape his clutches.",
            year = 2016,
            genre = listOf("Fantasy", "Adventure"),
            duration = "1h 46min",
            imdbRating = 7.4,
            poster = "https://i.pinimg.com/736x/44/0f/16/440f1647a05b7b145c6f00ed2163f00b.jpg",
            trailer = listOf(Trailer(10, "https://example.com/little_mermaid_trailer.mp4", 95)),
            parentalRating = "PG"
        ),
        Movie(
            id = 20,
            title = "Cinderella",
            description = "Ella resides with her abusive stepmother and her daughters who continuously make her suffer at home. Her life changes when she meets a handsome man of nobility who gives her a chance to become free.",
            year = 2015,
            genre = listOf("Family", "Fantasy"),
            duration = "1h 45min",
            imdbRating = 6.9,
            poster = "https://i.pinimg.com/736x/84/9d/59/849d595bdbcbb8e178361e583b3bc619.jpg",
            trailer = listOf(Trailer(10, "https://example.com/little_mermaid_trailer.mp4", 95)),
            parentalRating = "PG"
        ),
        Movie(
            id = 21,
            title = "Dora and the Lost City of Gold",
            description = "Dora Marquez embarks on a mission with her monkey, Boots, and her friends to rescue her missing parents and solve the mystery of a fabled city of gold.",
            year = 2019,
            genre = listOf("Adventure", "Comedy"),
            duration = "1h 42min",
            imdbRating = 6.1,
            poster = "https://i.pinimg.com/736x/90/c8/be/90c8beada14cac84cc53e6bdf5ebf253.jpg",
            trailer = listOf(Trailer(10, "https://example.com/little_mermaid_trailer.mp4", 95)),
            parentalRating = "PG"
        ),
        Movie(
            id = 22,
            title = "The Lost City",
            description = "A novelist is abducted by an eccentric billionaire who wants her to locate a lost treasure. Chaos ensues when a model sets out to rescue her from him.",
            year = 2022,
            genre = listOf("Action", "Comedy"),
            duration = "1h 52min",
            imdbRating = 6.1,
            poster = "https://i.pinimg.com/736x/3a/8a/64/3a8a647dd574d17885c4d87342c42c20.jpg",
            trailer = listOf(Trailer(10, "https://example.com/little_mermaid_trailer.mp4", 95)),
            parentalRating = "PG-13"
        ),
        Movie(
            id = 23,
            title = "Last Christmas",
            description = "Influenced by ambivalence, Katarina, an aspiring singer, works as an elf in Central London. However, she gains a new perspective on life when she meets Tom.",
            year = 2019,
            genre = listOf("Romance", "Comedy"),
            duration = "1h 43min",
            imdbRating = 6.5,
            poster = "https://i.pinimg.com/736x/3c/2e/3a/3c2e3a70d7f2738d8a3ed6bf2b7cfa14.jpg",
            trailer = listOf(Trailer(10, "https://example.com/little_mermaid_trailer.mp4", 95)),
            parentalRating = "PG-13"
        ),
        Movie(
            id = 24,
            title = "Let It Snow",
            description = "Influenced by ambivalence, Katarina, an aspiring singer, works as an elf in Central London. However, she gains a new perspective on life when she meets Tom.",
            year = 2019,
            genre = listOf("Romance", "Comedy"),
            duration = "1h 33min",
            imdbRating = 5.8,
            poster = "https://i.pinimg.com/736x/92/d9/40/92d9401f824f08b7f0e77c791dad04f2.jpg",
            trailer = listOf(Trailer(10, "https://example.com/little_mermaid_trailer.mp4", 95)),
            parentalRating = "PG-13"
        ),
        Movie(
            id = 25,
            title = "Barbie",
            description = "Barbie and Ken are having the time of their lives in the colorful and seemingly perfect world of Barbie Land. However, when they get a chance to go to the real world, they soon discover the joys and perils of living among humans.",
            year = 2023,
            genre = listOf("Fantasy", "Comedy"),
            duration = "1h 54min",
            imdbRating = 6.8,
            poster = "https://i.pinimg.com/736x/db/35/a2/db35a21424d9e478c969dd80ac29c037.jpg",
            trailer = listOf(Trailer(10, "https://example.com/little_mermaid_trailer.mp4", 95)),
            parentalRating = "PG-13"
        ),
        Movie(
            id = 26,
            title = "Crater",
            description = "Caleb Channing is about to be relocated to an idyllic faraway planet following his father's death. To fulfill his dad's last wish before leaving, he and his three best friends hijack a rover to explore a mysterious crater.",
            year = 2023,
            genre = listOf("Adventure", "Sci-fi"),
            duration = "1h 45min",
            imdbRating = 5.4,
            poster = "https://i.pinimg.com/736x/61/ee/a7/61eea7142d8876211c60fa5480465097.jpg",
            trailer = listOf(Trailer(10, "https://example.com/little_mermaid_trailer.mp4", 95)),
            parentalRating = "PG-13"
        ),
        Movie(
            id = 27,
            title = "Mission: Impossible – Dead Reckoning Part One",
            description = "Ethan Hunt and the IMF team must track down a terrifying new weapon that threatens all of humanity if it falls into the wrong hands. With control of the future and the fate of the world at stake, a deadly race around the globe begins. Confronted by a mysterious, all-powerful enemy, Ethan is forced to consider that nothing can matter more than the mission -- not even the lives of those he cares about most.",
            year = 2023,
            genre = listOf("Action", "Thriller"),
            duration = "2h 43min",
            imdbRating = 7.7,
            poster = "https://i.pinimg.com/736x/53/58/8b/53588bcd0d0b9e9cfbb3aaf0848e357b.jpg",
            trailer = listOf(Trailer(10, "https://example.com/little_mermaid_trailer.mp4", 95)),
            parentalRating = "PG-13"
        ),
        Movie(
            id = 28,
            title = "Top Gun: Maverick",
            description = "Thirty years of service leads Maverick to train a group of elite TOPGUN graduates to prepare for a high-profile mission while Maverick battles his past demons.",
            year = 2022,
            genre = listOf("Action", "Adventure"),
            duration = "2h 13min",
            imdbRating = 8.2,
            poster = "https://i.pinimg.com/736x/e5/83/b4/e583b43e320271408499d7af729a81b4.jpg",
            trailer = listOf(Trailer(10, "https://example.com/little_mermaid_trailer.mp4", 95)),
            parentalRating = "PG-13"
        )
    )
}