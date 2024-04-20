package com.ymistudios.disneyhotstar.di.module

import com.ymistudios.disneyhotstar.data.datasource.MovieDataSource
import com.ymistudios.disneyhotstar.data.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideMovieRepository(
        movieDataSource: MovieDataSource
    ): MovieRepository
}