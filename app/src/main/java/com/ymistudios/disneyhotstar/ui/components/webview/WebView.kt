package com.ymistudios.disneyhotstar.ui.components.webview

import android.webkit.WebView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.ymistudios.disneyhotstar.ui.toolbarmanager.Toolbar
import com.ymistudios.disneyhotstar.ui.toolbarmanager.ToolbarManager

@Composable
fun WebViewScreen(webViewState: WebViewState) {
    ToolbarManager.setUpToolbar(
        Toolbar(
            showToolbar = true,
            toolbarTitle = webViewState.title,
            showBackButton = true
        )
    )
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            WebView(context).apply {
                loadUrl(WebViewType.valueOf(webViewState.webViewType).webUrl)
            }
        }
    )
}

data class WebViewState(
    val title: String,
    val webViewType: String
)

enum class WebViewType(val webUrl: String) {
    ABOUT_US("https://www.google.com"),
    HELP_AND_FAQ("https://www.google.com"),
    TERMS_AND_CONDITIONS("https://www.google.com"),
    PRIVACY_POLICY("https://www.google.com"),
}