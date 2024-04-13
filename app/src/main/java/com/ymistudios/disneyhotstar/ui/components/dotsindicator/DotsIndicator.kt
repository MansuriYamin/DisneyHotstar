package com.ymistudios.disneyhotstar.ui.components.dotsindicator

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ymistudios.disneyhotstar.ui.theme.AppTheme

@Composable
fun DotsIndicator(
    modifier: Modifier = Modifier,
    totalDots: Int,
    selectedIndex: Int,
    selectedDotWidth: Dp = 12.dp,
    unSelectedDotWidth: Dp = 10.dp
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(totalDots) { index ->
            val width by animateDpAsState(
                targetValue = if (index == selectedIndex) selectedDotWidth else unSelectedDotWidth,
                animationSpec = tween(animationDuration),
                label = "width"
            )
            val height by animateDpAsState(
                targetValue = if (index == selectedIndex) selectedDotWidth else unSelectedDotWidth,
                animationSpec = tween(animationDuration),
                label = "height"
            )
            val color by animateColorAsState(
                targetValue = if (index == selectedIndex) AppTheme.colors.primary else LightGray,
                animationSpec = tween(animationDuration),
                label = "color"
            )

            Dot(backgroundColor = color, width = width, height = height, index == selectedIndex)

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}

@Composable
private fun Dot(backgroundColor: Color, width: Dp, height: Dp, isSelected: Boolean) {
    Box(contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .size(width = width, height = height)
                .clip(CircleShape)
                .background(backgroundColor)
        )
        if (isSelected)
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.White)
                    .padding(2.dp)
            )
    }
}

private const val animationDuration = 500

@Preview
@Composable
private fun DotsIndicatorPrev() {
    DotsIndicator(totalDots = 3, selectedIndex = 2)
}
