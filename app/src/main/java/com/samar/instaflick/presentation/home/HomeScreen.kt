package com.samar.instaflick.presentation.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.samar.instaflick.R
import com.samar.instaflick.presentation.common.OppositeThemeColor
import com.samar.instaflick.presentation.common.ThemeColor
import com.samar.instaflick.presentation.home.component.StatusBar
import com.samar.instaflick.presentation.ui.theme.SkyBlue
import com.samar.instaflick.presentation.ui.theme.fonts
import com.samar.instaflick.util.sdp
import com.samar.instaflick.util.textSdp

@Composable
fun HomeScreen() {
    LazyColumn {
        item {
            LazyRow {
                item {
                    Row {
                        Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                        Column {
                            Box(
                                modifier = Modifier
                                    .size(60.sdp)
                            ) {
                                Card(
                                    modifier = Modifier
                                        .size(55.sdp)
                                        .align(Alignment.Center),
                                    shape = CircleShape,
                                    border = BorderStroke(width = 0.25.dp, color = ThemeColor())
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.dp),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop
                                    )
                                }

                                Card(
                                    modifier = Modifier
                                        .align(Alignment.BottomEnd)
                                        .padding(bottom = 4.dp),
                                    border = BorderStroke(1.sdp, color = OppositeThemeColor()),
                                    shape = CircleShape,
                                    backgroundColor = SkyBlue,
                                    contentColor = Color.White
                                ) {
                                    Icon(
                                        modifier = Modifier
                                            .size(20.dp)
                                            .padding(3.dp),
                                        imageVector = Icons.Default.Add,
                                        contentDescription = null
                                    )
                                }
                            }
                            Text(
                                modifier = Modifier
                                    .padding(vertical = 5.dp)
                                    .align(Alignment.CenterHorizontally),
                                text = "Your story",
                                maxLines = 1,
                                color = ThemeColor(),
                                fontSize = 10.textSdp,
                                fontFamily = fonts
                            )
                        }
                    }
                }
                items(10) {
                    Spacer(modifier = Modifier.padding(end = 10.sdp))
                    StatusBar()
                }
            }
        }
    }
}