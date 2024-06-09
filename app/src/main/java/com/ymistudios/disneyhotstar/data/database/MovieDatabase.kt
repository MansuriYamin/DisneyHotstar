package com.ymistudios.disneyhotstar.data.database

import com.ymistudios.disneyhotstar.data.pojo.movie.Header
import com.ymistudios.disneyhotstar.data.pojo.movie.Movie
import com.ymistudios.disneyhotstar.data.pojo.movie.Trailer

object MovieDatabase {

    val headers = listOf(
        Header(header = "For You", type = Header.Type.FOR_YOU),
        Header(header = "Continue Watching", type = Header.Type.CONTINUE_WATCHING),
        Header(header = "Trending", type = Header.Type.TRENDING),
        Header(header = "Latest Releases", type = Header.Type.LATEST_RELEASES),
        Header(header = "Popular", type = Header.Type.POPULAR),
        Header(header = "For Kids", type = Header.Type.FOR_KIDS)
    )

    val movieList = listOf(
        Movie(
            id = 1,
            title = "Zootopia",
            description = "When Judy Hopps, a rookie officer in the Zootopia Police Department, sniffs out a sinister plot, she enlists the help of a con artist to solve the case in order to prove her abilities to Chief Bogo.",
            year = 2016,
            genre = listOf("Family", "Adventure", "Comedy", "Mystery"),
            duration = "1h 48min",
            imdbRating = 8.0,
            poster = "https://i.pinimg.com/736x/aa/39/57/aa39574b40081259b8b674dcc78c86d3.jpg",
            trailers = listOf(
                Trailer(
                    id = 1,
                    thumbnail = "https://i.pinimg.com/736x/4d/af/30/4daf301bc5dd52e4b3d6e30e7bffeeb1.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 2,
                    thumbnail = "https://i.pinimg.com/736x/5f/70/05/5f700505f4686bbf2c41b76bba3bbf0a.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 3,
                    thumbnail = "https://i.pinimg.com/736x/f3/ea/46/f3ea46dbd26c1a0c7bfb3fc034876cc0.jpg",
                    duration = "2:05"
                )
            ),
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
            poster = "https://i.pinimg.com/736x/06/e2/f4/06e2f4dbd0408c4628de070599041792.jpg",
            trailers = listOf(
                Trailer(
                    id = 4,
                    thumbnail = "https://i.pinimg.com/736x/4d/58/26/4d58263914c22759e673203ed1c82578.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 5,
                    thumbnail = "https://i.pinimg.com/736x/06/0f/f0/060ff06fc443fb2d00acac84579ab581.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 5,
                    thumbnail = "https://i.pinimg.com/736x/34/94/53/3494534f563fcd68998b5f33ec3c4aed.jpg",
                    duration = "2:05"
                )
            ),
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
            trailers = listOf(
                Trailer(
                    id = 6,
                    thumbnail = "https://i.pinimg.com/736x/e5/dd/62/e5dd620892b9182622bb3cb306f11319.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 7,
                    thumbnail = "https://i.pinimg.com/736x/ab/51/40/ab5140225babd73a2d6f8d6d1793949a.jpg",
                    duration = "2:05"
                )
            ),
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
            trailers = listOf(
                Trailer(
                    id = 8,
                    thumbnail = "https://i.pinimg.com/736x/ac/dd/46/acdd46b13a70bf3da04344e5d0b8c957.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 9,
                    thumbnail = "https://i.pinimg.com/736x/47/94/ad/4794ad3d180f6d656c9b3422041d5e87.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 10,
                    thumbnail = "https://i.pinimg.com/736x/0b/14/6b/0b146b7f24006baa8633c154fc3cf72f.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 11,
                    thumbnail = "https://i.pinimg.com/736x/4a/3f/dd/4a3fdde24a1e8dfc53dc5ac4a906e4bc.jpg",
                    duration = "2:05"
                )
            ),
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
            trailers = listOf(
                Trailer(
                    id = 12,
                    thumbnail = "https://i.pinimg.com/736x/d5/28/70/d52870c7071df4d9f745af11c024a3be.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 13,
                    thumbnail = "https://i.pinimg.com/736x/00/07/0e/00070eb2d73b777a2ef97b6a005eab0f.jpg",
                    duration = "2:05"
                )
            ),
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
            trailers = listOf(
                Trailer(
                    id = 14,
                    thumbnail = "https://i.pinimg.com/736x/8c/cf/b0/8ccfb08c386cee176ade21e3cd76b352.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 15,
                    thumbnail = "https://i.pinimg.com/736x/e4/1c/3e/e41c3e84232f4452ad983346dd4f55ba.jpg",
                    duration = "2:05"
                )
            ),
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
            trailers = listOf(
                Trailer(
                    id = 16,
                    thumbnail = "https://i.pinimg.com/736x/7b/22/a0/7b22a0399c57ebac8e9d6f33ebdb8f1b.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 17,
                    thumbnail = "https://i.pinimg.com/736x/e7/e6/a4/e7e6a464019cbfedf441704991a5f45f.jpg",
                    duration = "2:05"
                )
            ),
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
            trailers = listOf(
                Trailer(
                    id = 18,
                    thumbnail = "https://i.pinimg.com/736x/f8/88/57/f8885796b4e98b5686cce8c5ed826911.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 19,
                    thumbnail = "https://i.pinimg.com/736x/5b/f5/83/5bf583c94f71c592b8638e8c6895789c.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 20,
                    thumbnail = "https://i.pinimg.com/736x/3c/af/d6/3cafd60cdab3d3cf358491bfb843646b.jpg",
                    duration = "2:05"
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
            trailers = listOf(
                Trailer(
                    id = 21,
                    thumbnail = "https://i.pinimg.com/736x/51/7c/3f/517c3fb8dc8b96d5247bafe4b1ac64be.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 22,
                    thumbnail = "https://i.pinimg.com/736x/05/a7/05/05a705a77cdd6f742723c933d635bedf.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 23,
                    thumbnail = "https://i.pinimg.com/736x/ee/68/21/ee6821995cd2343ff6de58f8247bb7a6.jpg",
                    duration = "2:05"
                )
            ),
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
            trailers = listOf(
                Trailer(
                    id = 24,
                    thumbnail = "https://i.pinimg.com/736x/85/02/fa/8502fa9da2eb10d48be78428866822f4.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 25,
                    thumbnail = "https://i.pinimg.com/736x/83/33/e9/8333e9fabd527b28475f339d801b25d3.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 26,
                    thumbnail = "https://i.pinimg.com/736x/72/e7/47/72e7478475e4055f048156d0c1d93c32.jpg",
                    duration = "2:05"
                )
            ),
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
            trailers = listOf(
                Trailer(
                    id = 27,
                    thumbnail = "https://i.pinimg.com/736x/b3/ba/11/b3ba110c5890d6b1695c178127729ab8.jpg",
                    duration = "2:05"
                )
            ),
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
            trailers = listOf(
                Trailer(
                    id = 28,
                    thumbnail = "https://i.pinimg.com/736x/34/80/ee/3480ee4f058d72ffdf4814e3d51838be.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 29,
                    thumbnail = "https://i.pinimg.com/736x/96/d9/98/96d9980ccf3e97c62cb1822bc71f4f08.jpg",
                    duration = "2:05"
                )
            ),
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
            trailers = listOf(
                Trailer(
                    id = 30,
                    thumbnail = "https://i.pinimg.com/736x/78/fd/e2/78fde25963ddb0f55d0f5d4fea9b0cbe.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 31,
                    thumbnail = "https://i.pinimg.com/736x/6b/d8/bd/6bd8bd066439faf434f4c37f3979d781.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 32,
                    thumbnail = "https://i.pinimg.com/736x/3d/35/df/3d35dfbf94d281fbd7023451695d9ba4.jpg",
                    duration = "2:05"
                )
            ),
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
            trailers = listOf(
                Trailer(
                    id = 33,
                    thumbnail = "https://i.pinimg.com/736x/9c/f1/65/9cf165e22ed5182fe38e57bb5bab74b7.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 34,
                    thumbnail = "https://i.pinimg.com/736x/a0/3f/fa/a03ffa9f96da6c075a112d8e2f310220.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 35,
                    thumbnail = "https://i.pinimg.com/736x/96/31/2f/96312fa1aaf6f95ab209324c6ae126d4.jpg",
                    duration = "2:05"
                )
            ),
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
            trailers = listOf(
                Trailer(
                    id = 36,
                    thumbnail = "https://i.pinimg.com/736x/c9/d5/cd/c9d5cdf9b92a857bb854a99cbbc226ed.jpg",
                    duration = "2:05"
                )
            ),
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
            trailers = listOf(
                Trailer(
                    id = 37,
                    thumbnail = "https://i.pinimg.com/736x/ea/99/4c/ea994c463641f7556c86a2ef5be6e6a9.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 38,
                    thumbnail = "https://i.pinimg.com/736x/ed/70/b5/ed70b5893690daf343bf78049646cdfd.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 39,
                    thumbnail = "https://i.pinimg.com/736x/53/c7/52/53c7525f752d6e1fbea775f3e7c3ff0a.jpg",
                    duration = "2:05"
                )
            ),
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
            trailers = listOf(
                Trailer(
                    id = 40,
                    thumbnail = "https://i.pinimg.com/736x/57/ce/50/57ce502b4a9f86e7e2c7776222f94a96.jpg",
                    duration = "2:05"
                )
            ),
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
            trailers = listOf(
                Trailer(
                    id = 41,
                    thumbnail = "https://i.pinimg.com/736x/1f/30/84/1f3084cee9ac8ead7b3d4615fac6821b.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 42,
                    thumbnail = "https://i.pinimg.com/736x/e3/9a/6b/e39a6bd8e1525087640af552ad3a80cc.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 43,
                    thumbnail = "https://i.pinimg.com/736x/37/ff/c8/37ffc892fabc646210ff13dfb5d6a36a.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 44,
                    thumbnail = "https://i.pinimg.com/736x/d8/de/49/d8de49a114a0c87d3c03facaa7d77404.jpg",
                    duration = "2:05"
                )
            ),
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
            trailers = listOf(
                Trailer(
                    id = 45,
                    thumbnail = "https://i.pinimg.com/736x/d4/73/eb/d473eb10ec8e2623e5274b3d26f46b5a.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 46,
                    thumbnail = "https://i.pinimg.com/736x/6f/2c/4b/6f2c4bd36069c387f5e32d63965e2daa.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 47,
                    thumbnail = "https://i.pinimg.com/736x/36/46/89/364689ac126f37cb031117291a3ce79f.jpg",
                    duration = "2:05"
                )
            ),
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
            trailers = listOf(
                Trailer(
                    id = 48,
                    thumbnail = "https://i.pinimg.com/736x/8d/63/c3/8d63c3a35dae71da76af07881e2fe5a1.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 49,
                    thumbnail = "https://i.pinimg.com/736x/3d/69/f6/3d69f6ce165cf5d715f902e3c694fb55.jpg",
                    duration = "2:05"
                )
            ),
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
            trailers = listOf(
                Trailer(
                    id = 50,
                    thumbnail = "https://i.pinimg.com/736x/1d/28/f8/1d28f8e06f88f69eb16368a874cee253.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 51,
                    thumbnail = "https://i.pinimg.com/736x/99/5d/52/995d526028b717c37f7bd256a8ca5bb5.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 52,
                    thumbnail = "https://i.pinimg.com/736x/8b/85/38/8b8538aa933fd3c73bebd37e8dd6934f.jpg",
                    duration = "2:05"
                )
            ),
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
            trailers = listOf(
                Trailer(
                    id = 53,
                    thumbnail = "https://i.pinimg.com/736x/e1/79/4f/e1794f4fbf71f92e4f23d0eb766f1ded.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 54,
                    thumbnail = "https://i.pinimg.com/736x/da/88/4e/da884e3810a3edbc57614b5d33fb7ff8.jpg",
                    duration = "2:05"
                )
            ),
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
            trailers = listOf(
                Trailer(
                    id = 55,
                    thumbnail = "https://i.pinimg.com/736x/33/c0/e4/33c0e49f7d067ea36013af21bada8647.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 56,
                    thumbnail = "https://i.pinimg.com/736x/95/4c/2a/954c2a3544f29937d860cbd49199f8e4.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 57,
                    thumbnail = "https://i.pinimg.com/736x/83/65/62/8365628e91d153f7c72d9d8e1d767f1a.jpg",
                    duration = "2:05"
                )
            ),
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
            trailers = listOf(
                Trailer(
                    id = 58,
                    thumbnail = "https://i.pinimg.com/736x/13/19/36/13193691b34b9f092641ff893edbc4b9.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 59,
                    thumbnail = "https://i.pinimg.com/736x/3e/f8/b6/3ef8b6a3cc4344e7a6125c8283b585e2.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 60,
                    thumbnail = "https://i.pinimg.com/736x/65/57/a8/6557a88ff77de845435853939e72acf7.jpg",
                    duration = "2:05"
                )
            ),
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
            trailers = listOf(
                Trailer(
                    id = 61,
                    thumbnail = "https://i.pinimg.com/736x/12/d1/8b/12d18b56872202b89c7a653df89c2744.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 62,
                    thumbnail = "https://i.pinimg.com/736x/a8/35/15/a83515ac0f7e5097dba638b47338da42.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 63,
                    thumbnail = "https://i.pinimg.com/736x/11/94/70/1194705623e8073edb07d3dc825cdb1a.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 64,
                    thumbnail = "https://i.pinimg.com/736x/0b/33/9e/0b339e7ec2a4eac02584aa7427eb13a0.jpg",
                    duration = "2:05"
                )
            ),
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
            trailers = listOf(
                Trailer(
                    id = 65,
                    thumbnail = "https://i.pinimg.com/736x/45/aa/8a/45aa8ae5746f3873f14367fe14e55655.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 66,
                    thumbnail = "https://i.pinimg.com/736x/1a/c1/e7/1ac1e7b148e9bbbcc1e42ff32e0f2f87.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 67,
                    thumbnail = "https://i.pinimg.com/736x/3f/80/d7/3f80d7aa392d67880ec24b4c19bdcdf5.jpg",
                    duration = "2:05"
                )
            ),
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
            trailers = listOf(
                Trailer(
                    id = 68,
                    thumbnail = "https://i.pinimg.com/736x/be/60/f9/be60f96ed1a438c5a9a804b825fa00a6.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 69,
                    thumbnail = "https://i.pinimg.com/736x/54/43/a0/5443a0a6994b16732ad62efc67392158.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 70,
                    thumbnail = "https://i.pinimg.com/736x/55/fa/52/55fa525d8ec5df2bb9dfeaa9946d882c.jpg",
                    duration = "2:05"
                )
            ),
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
            poster = "https://i.pinimg.com/736x/a5/b6/bb/a5b6bb42dad3dad9f1f9a0fedcf2a688.jpg",
            trailers = listOf(
                Trailer(
                    id = 71,
                    thumbnail = "https://i.pinimg.com/736x/a0/07/1b/a0071be1e32e9e4f6ee0bf0a0d50a4ee.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 72,
                    thumbnail = "https://i.pinimg.com/736x/d8/d0/6f/d8d06fb021ac0e3feeac1a779fcb809d.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 73,
                    thumbnail = "https://i.pinimg.com/736x/1a/a8/9a/1aa89a695e641a15f52fb2f74722a9a6.jpg",
                    duration = "2:05"
                ),
                Trailer(
                    id = 74,
                    thumbnail = "https://i.pinimg.com/736x/be/38/83/be3883ed2c062b9f8373a0720808f985.jpg",
                    duration = "2:05"
                )
            ),
            parentalRating = "PG-13"
        )
    )
}