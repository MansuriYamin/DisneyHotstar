package com.ymistudios.macrobenchmark.baselineprofile

import androidx.benchmark.macro.junit4.BaselineProfileRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.ymistudios.macrobenchmark.benchmark.performScrollingAndNavigateToDetails
import com.ymistudios.macrobenchmark.utils.TARGET_PACKAGE
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class ScrollAndNavigateBaselineProfileGenerator {

    @get:Rule
    val rule = BaselineProfileRule()

    @Test
    fun generateBaselineProfile() {
        rule.collect(packageName = TARGET_PACKAGE) {
            startActivityAndWait()
            performScrollingAndNavigateToDetails()
        }
    }
}