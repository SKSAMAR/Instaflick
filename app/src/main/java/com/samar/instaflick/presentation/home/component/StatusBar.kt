package com.samar.instaflick.presentation.home.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.samar.instaflick.R
import com.samar.instaflick.presentation.common.OppositeThemeColor
import com.samar.instaflick.presentation.common.ThemeColor
import com.samar.instaflick.presentation.ui.theme.*
import com.samar.instaflick.util.sdp
import com.samar.instaflick.util.textSdp


@Composable
fun StatusBar(){
    Column(modifier = Modifier.width(70.dp)) {

        Card(
            modifier = Modifier.size(60.sdp),
            shape = CircleShape,
//            border = BorderStroke(
//                1.5.dp,
//                brush = Brush.verticalGradient(colors = listOf(
//                    Orange,
//                    Purple,
//                    LightYellow,
//                    Orange,
//                    Pink,
//                    Purple,
//                    Blue
//                ))
//            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ){
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id =R.drawable.insta_circle),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )

                Card(
                    modifier = Modifier
                        .size(55.sdp)
                        .align(Alignment.Center),
                    shape = CircleShape,
                    border = BorderStroke(
                        1.sdp,
                        color = OppositeThemeColor()
                    )
                ){
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = R.drawable.dp),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }

            }
        }
        Text(
            modifier = Modifier
                .padding(vertical = 5.dp)
                .align(Alignment.CenterHorizontally),
            text = "Mark Bro",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = ThemeColor(),
            fontSize = 10.textSdp,
            fontFamily = fonts
        )
    }
}