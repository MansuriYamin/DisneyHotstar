package com.ymistudios.utils

import androidx.test.platform.app.InstrumentationRegistry

val TARGET_PACKAGE = InstrumentationRegistry.getArguments().getString("targetAppId")
    ?: throw Exception("targetAppId not passed as instrumentation runner arg")
