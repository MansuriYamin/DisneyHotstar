package com.ymistudios.benchmark

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
import com.ymistudios.utils.TARGET_PACKAGE
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class HomeScrollingBenchmarks {

    @get:Rule
    val rule = MacrobenchmarkRule()

    @Test
    fun homeScrollingCompilationNone() =
        homeScrollingBenchmark(CompilationMode.None())

    @Test
    fun homeScrollingCompilationBaselineProfiles() =
        homeScrollingBenchmark(CompilationMode.Partial(BaselineProfileMode.Require))

    private fun homeScrollingBenchmark(compilationMode: CompilationMode) {
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
                scrollMovieList()
            }
        )
    }
}


fun MacrobenchmarkScope.scrollMovieList() {
    // Scroll horizontal list.
    val movieLazyRow = device.findObject(By.res("movieLazyRow"))
    movieLazyRow?.setGestureMargin(device.displayWidth / 5)
    movieLazyRow?.scroll(Direction.RIGHT, 1f)
    // Click the last item to navigate to details screen.
    movieLazyRow?.children?.lastOrNull()?.clickAndWait(Until.newWindow(), 3000)

    // In movie details screen, scroll content vertically down & up.
    val movieDetailsLazyColumn = device.findObject(By.res("movieDetailsLazyColumn"))
    movieDetailsLazyColumn?.setGestureMargin(device.displayWidth / 5)
    movieDetailsLazyColumn?.fling(Direction.DOWN)
    movieDetailsLazyColumn?.fling(Direction.UP)

    // Go back
    device.pressBack()
    device.waitForIdle()

    // Scroll the home screen's vertical list down & up.
    val movieLazyColumn = device.findObject(By.res("movieLazyColumn"))
    movieLazyColumn?.setGestureMargin(device.displayWidth / 5)
    movieLazyColumn?.fling(Direction.DOWN)
    movieLazyColumn?.fling(Direction.UP)
}
