plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    kotlin("plugin.serialization") version "1.9.23"
    id("androidx.baselineprofile")
}

kotlin {
    sourceSets {
        debug {
            kotlin.srcDir("build/generated/ksp/debug/kotlin")
        }
        release {
            kotlin.srcDir("build/generated/ksp/release/kotlin")
        }
    }
}

android {
    signingConfigs {
        create("release") {
            storeFile = file("E:\\Key\\DisneyHotstarKey.jks")
            storePassword = "123456"
            keyAlias = "disneyhotstar"
            keyPassword = "123456"
        }
    }
    val packageName = "com.ymistudios.disneyhotstar"
    namespace = packageName
    compileSdk = 34

    defaultConfig {
        applicationId = packageName
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        signingConfig = signingConfigs.getByName("release")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.13.1")
    implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.9.20"))
    implementation(platform("androidx.compose:compose-bom:2024.05.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.1")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.1")

    // Compose Util
    implementation("androidx.compose.ui:ui-util")

    // Compose Navigation
    implementation("androidx.navigation:navigation-compose:2.8.0-beta02")

    // Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")

    // Compose LiveData
    implementation("androidx.compose.runtime:runtime-livedata")

    // AppCompat
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.appcompat:appcompat-resources:1.7.0")

    // Splash screen
    implementation("androidx.core:core-splashscreen:1.0.1")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.49")
    implementation("androidx.profileinstaller:profileinstaller:1.3.1")
    "baselineProfile"(project(":baselineprofile"))
    kapt("com.google.dagger:hilt-compiler:2.49")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    // DataStore
    implementation("androidx.datastore:datastore-preferences:1.1.1")

    // SystemUIController
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.31.3-beta")

    // Coil
    implementation("io.coil-kt:coil-compose:2.4.0")

    // Sdp
    implementation("com.intuit.sdp:sdp-android:1.1.0")
    implementation("com.intuit.ssp:ssp-android:1.1.0")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.11")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.05.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}