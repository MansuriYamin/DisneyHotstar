package com.ymistudios.baselineprofile

import androidx.benchmark.macro.junit4.BaselineProfileRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.ymistudios.benchmark.scrollMovieList
import com.ymistudios.utils.TARGET_PACKAGE
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class HomeScrollingBaselineProfileGenerator {

    @get:Rule
    val rule = BaselineProfileRule()

    @Test
    fun generate() {
        rule.collect(packageName = TARGET_PACKAGE) {
            startActivityAndWait()
            scrollMovieList()
        }
    }
}