package com.ymistudios.macrobenchmark.benchmark

import androidx.benchmark.macro.BaselineProfileMode
import androidx.benchmark.macro.CompilationMode
import androidx.benchmark.macro.FrameTimingMetric
import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.benchmark.macro.StartupMode
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Direction
import androidx.test.uiautomator.Until
import com.ymistudios.macrobenchmark.utils.TARGET_PACKAGE
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class ScrollAndNavigateBenchmarks {

    @get:Rule
    val rule = MacrobenchmarkRule()

    @Test
    fun scrollAndNavigateCompilationNone() =
        scrollAndNavigateBenchmark(CompilationMode.None())

    @Test
    fun scrollAndNavigateCompilationBaselineProfiles() =
        scrollAndNavigateBenchmark(CompilationMode.Partial(BaselineProfileMode.Require))

    private fun scrollAndNavigateBenchmark(compilationMode: CompilationMode) {
        rule.measureRepeated(
            packageName = TARGET_PACKAGE,
            metrics = listOf(FrameTimingMetric()),
            compilationMode = compilationMode,
            startupMode = StartupMode.WARM,
            iterations = 10,
            setupBlock = {
                startActivityAndWait()
            },
            measureBlock = {
                performScrollingAndNavigateToDetails()
            }
        )
    }
}

fun MacrobenchmarkScope.performScrollingAndNavigateToDetails() {
    val deviceWidth = device.displayWidth
    val scrollMargin = deviceWidth / 5

    // Scroll horizontal list.
    device.findObject(By.res("movieLazyRow"))?.apply {
        setGestureMargin(scrollMargin)
        scroll(Direction.RIGHT, 1f)
        // Click the last item to navigate to details screen.
        children?.lastOrNull()?.clickAndWait(Until.newWindow(), 3000)
    }

    // In movie details screen, scroll content vertically down & up.
    device.findObject(By.res("movieDetailsLazyColumn"))?.apply {
        setGestureMargin(scrollMargin)
        fling(Direction.DOWN)
        fling(Direction.UP)
    }

    // Go back
    device.pressBack()
    device.waitForIdle()

    // Scroll the home screen's vertical list down & up.
    device.findObject(By.res("movieLazyColumn"))?.apply {
        setGestureMargin(scrollMargin)
        fling(Direction.DOWN)
        fling(Direction.UP)
    }
}
