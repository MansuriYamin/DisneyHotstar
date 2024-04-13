package com.ymistudios.disneyhotstar.di.module

import com.ymistudios.disneyhotstar.data.datastore.UserDataStore
import com.ymistudios.disneyhotstar.data.datastore.UserDataStoreImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class UserDataStoreModule {

    @Binds
    @Singleton
    abstract fun bindUserDataStore(userDataStoreImpl: UserDataStoreImpl): com.ymistudios.disneyhotstar.data.datastore.UserDataStore
}