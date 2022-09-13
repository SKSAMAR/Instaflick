package com.samar.instaflick.presentation.common

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun ThemeColor(): Color{
   return if(isSystemInDarkTheme()) Color.White else Color.Black
}

@Composable
fun OppositeThemeColor(): Color{
   return if(isSystemInDarkTheme()) Color.Black else Color.White
}