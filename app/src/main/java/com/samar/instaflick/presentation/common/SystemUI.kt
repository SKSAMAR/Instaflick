package com.samar.instaflick.presentation.common

import android.os.Build
import android.view.View
import android.view.Window
import androidx.annotation.RequiresApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toArgb
import com.samar.instaflick.presentation.ui.theme.InstaflickTheme

@Composable
fun SystemUi(windows: Window) =
    InstaflickTheme {
        windows.statusBarColor = MaterialTheme.colors.surface.toArgb()
        windows.navigationBarColor = MaterialTheme.colors.surface.toArgb()

        @Suppress("DEPRECATION")
        if (MaterialTheme.colors.surface.luminance() > 0.5f) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                windows.decorView.systemUiVisibility = windows.decorView.systemUiVisibility or
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
        }

        @Suppress("DEPRECATION")
        if (MaterialTheme.colors.surface.luminance() > 0.5f) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                windows.decorView.systemUiVisibility = windows.decorView.systemUiVisibility or
                        View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            }
        }
    }