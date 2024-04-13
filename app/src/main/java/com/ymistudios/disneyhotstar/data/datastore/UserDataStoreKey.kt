package com.ymistudios.disneyhotstar.data.datastore

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object UserDataStoreKey {
    val IS_USER_LOGGED_IN = booleanPreferencesKey("isUserLoggedIn")
    val SHOULD_SHOW_TUTORIAL_SCREEN = booleanPreferencesKey("shouldShowTutorialScreen")
    val LANGUAGE = stringPreferencesKey("language")

    const val USER_DATA_STORE = "USER_DATA_STORE"
}