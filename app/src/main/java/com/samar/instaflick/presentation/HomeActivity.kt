package com.samar.instaflick.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.samar.instaflick.data.common.BaseComponentAct
import com.samar.instaflick.presentation.common.SystemUi
import com.samar.instaflick.presentation.ui.theme.InstaflickTheme
import com.samar.instaflick.R
import com.samar.instaflick.data.common.ClearRippleTheme
import com.samar.instaflick.presentation.common.ThemeColor
import com.samar.instaflick.presentation.home.HomeScreen
import com.samar.instaflick.util.sdp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseComponentAct() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SystemUi(windows = window)
            InstaflickTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomeInstallation()
                }
            }
        }
    }

    @Composable
    private fun HomeInstallation() {
        BaseScaffold(
            topBar = {
                TopAppBar(
                    elevation = 0.dp,
                    backgroundColor = if (isSystemInDarkTheme()) Color.Black else Color.White,
                    contentColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                ) {
                    CompositionLocalProvider(LocalRippleTheme provides ClearRippleTheme) {
                        Row(
                            modifier = Modifier.clickable {

                            },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                modifier = Modifier
                                    .fillMaxHeight(.6f)
                                    .padding(start = 10.sdp),
                                painter = painterResource(id = R.drawable.logo),
                                contentDescription = null,
                                tint = ThemeColor()
                            )
                            Icon(
                                modifier = Modifier
                                    .size(14.dp)
                                    .padding(start = 1.sdp),
                                painter = painterResource(id = R.drawable.arrow_down),
                                contentDescription = null,
                                tint = ThemeColor()
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(.9f)
                                .fillMaxHeight(.6f),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.End
                        ) {
                            Icon(
                                modifier = Modifier.size(16.sdp),
                                painter = painterResource(id = R.drawable.add),
                                contentDescription = null,
                                tint = ThemeColor()
                            )
                            Spacer(modifier = Modifier.width(15.sdp))
                            Icon(
                                modifier = Modifier.size(16.sdp),
                                painter = painterResource(id = R.drawable.messenger),
                                contentDescription = null,
                                tint = ThemeColor()
                            )
                        }
                    }
                }
            }
        ) {
            HomeScreen()
        }
    }
}