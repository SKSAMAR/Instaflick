package com.samar.instaflick.presentation.home.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.samar.instaflick.R
import com.samar.instaflick.domain.model.PostModel
import com.samar.instaflick.presentation.common.OppositeThemeColor
import com.samar.instaflick.presentation.common.ThemeColor
import com.samar.instaflick.presentation.ui.theme.SkyBlue
import com.samar.instaflick.presentation.ui.theme.fonts
import com.samar.instaflick.util.sdp
import com.samar.instaflick.util.textSdp
import kotlinx.coroutines.delay

@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
fun ImagesPosts(
    postModel: PostModel = hughJackManPost
) {
    val pageState = rememberPagerState(initialPage = 0)
    var postLiked by remember { mutableStateOf(postModel.isLiked) }

    var justSlided by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = pageState.isScrollInProgress){
        if (!pageState.isScrollInProgress){
            justSlided = true
            delay(2000)
            justSlided = false
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(.9f)
                .height(45.sdp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Card(
                    modifier = Modifier
                        .size(32.sdp)
                        .clip(CircleShape),
                    shape = CircleShape,
                    border = BorderStroke(
                        width = 1.sdp,
                        color = OppositeThemeColor()
                    )
                ) {
                    AsyncImage(
                        modifier = Modifier.fillMaxSize(),
                        model = postModel.profileImage,
                        contentDescription = "profile_image",
                        contentScale = ContentScale.Crop
                    )
                }

                Text(
                    modifier = Modifier.padding(start = 8.sdp),
                    text = postModel.userName,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = ThemeColor(),
                    fontSize = 10.textSdp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = fonts
                )
            }

            Icon(
                modifier = Modifier
                    .size(18.sdp),
                imageVector = Icons.Default.MoreVert,
                contentDescription = "more"
            )
        }
        Divider(modifier = Modifier.fillMaxWidth(.95f))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(230.sdp)
                .clip(RectangleShape)
        ) {
            HorizontalPager(
                count = postModel.postData.size,
                state = pageState
            ) { items ->
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {

                    AsyncImage(
                        model = postModel.postData[items],
                        modifier = Modifier.fillMaxSize(),
                        contentDescription = "post_image",
                        contentScale = ContentScale.Crop
                    )
                }
            }

            if(justSlided){
                Card(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(10.sdp),
                    elevation = 0.sdp,
                    shape = RoundedCornerShape(10.sdp),
                    backgroundColor = Color.Black.copy(alpha = 0.5f)
                ) {
                Text(
                    modifier = Modifier.padding(vertical = 3.sdp, horizontal = 7.sdp),
                    text = "${pageState.currentPage + 1}/${postModel.postData.size}",
                    fontSize = 11.textSdp,
                    color = Color.White
                )
            }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(.9f)
                .height(30.sdp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    modifier = Modifier
                        .clickable {
                            postLiked = !postLiked
                            postModel.isLiked = !postModel.isLiked
                        }
                        .size(20.sdp),
                    model =
                        if (!postLiked && isSystemInDarkTheme())
                            R.drawable.light_dislike
                        else if (!postLiked && !isSystemInDarkTheme())
                            R.drawable.dark_dislike
                        else R.drawable.liked
                    ,
                    contentDescription = "",
                )
                Spacer(modifier = Modifier.width(10.sdp))
                AsyncImage(
                    modifier = Modifier
                        .size(20.sdp),
                    model = if (isSystemInDarkTheme())
                            R.drawable.comment_light
                        else R.drawable.comment_dark
                    ,
                    contentDescription = "",
                )
                Spacer(modifier = Modifier.width(10.sdp))
                AsyncImage(
                    modifier = Modifier
                        .size(20.sdp),
                    model = if (isSystemInDarkTheme())
                            R.drawable.light_share
                        else R.drawable.dark_share,
                    contentDescription = "",
                )
                Spacer(modifier = Modifier.width(20.sdp))
            }

            HorizontalPagerIndicator(
                pagerState = pageState,
                inactiveColor = Color.Gray,
                activeColor = SkyBlue,
                indicatorHeight = 4.sdp,
                indicatorWidth = 4.sdp,
                spacing = 4.sdp
            )

            Row {
                Spacer(modifier = Modifier.width(10.sdp))
                Spacer(modifier = Modifier.width(20.sdp))
                Spacer(modifier = Modifier.width(10.sdp))
                Spacer(modifier = Modifier.width(20.sdp))
                AsyncImage(
                    modifier = Modifier
                        .size(20.sdp),
                    model = if (isSystemInDarkTheme())
                            R.drawable.light_bookmark
                        else R.drawable.dark_bookmark,
                    contentDescription = "",
                )
            }

        }
        Column(
            modifier = Modifier
                .fillMaxWidth(.9f)
                .padding(vertical = 2.sdp),
        ) {
            Text(
                text = "${postModel.numOfLikes} likes",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = ThemeColor(),
                fontSize = 11.textSdp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = fonts
            )

            var maxLines by remember {
                mutableStateOf(1)
            }
            FlowRow {
                Text(
                    modifier = Modifier.weight(1f),
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Black,
                                fontWeight = FontWeight.SemiBold
                            )
                        ) {
                            append(postModel.userName + " ")
                        }
                        append(postModel.description)
                    },
                    maxLines = maxLines,
                    overflow = TextOverflow.Ellipsis,
                    color = ThemeColor(),
                    fontSize = 11.textSdp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = fonts
                )
                if(postModel.description.length>20){
                    Text(
                        modifier = Modifier.clickable {
                            maxLines = if(maxLines>=10) 1
                            else 10
                        },
                        text = if(maxLines>=10) "less" else "more",
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        color = ThemeColor(),
                        fontSize = 11.textSdp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = fonts
                    )
                }
            }

        }

        Row(
            modifier = Modifier
                .fillMaxWidth(.9f)
        ){
            Text(
                text = ""+postModel.postedOn,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.Gray,
                fontSize = 8.textSdp,
                fontWeight = FontWeight.Normal,
                fontFamily = fonts
            )
        }

    }
}

val hughJackmanImages = listOf(
    R.drawable.insta_image_first,
    R.drawable.instag_image_second,
    R.drawable.insta_image_third,
    R.drawable.insta_image_forth,
)

val hughJackManPost = PostModel(
    userId = "1",
    isLiked = false,
    profileImage = R.drawable.insta_image_first,
    userName = "hugh_jackman",
    postData = hughJackmanImages
)