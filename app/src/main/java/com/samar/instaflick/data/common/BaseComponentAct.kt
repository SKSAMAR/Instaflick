package com.samar.instaflick.data.common

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.webspidy.mtt1merchant.util.ConnectionLiveData
import dagger.hilt.android.AndroidEntryPoint
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.CollapsingToolbarScope
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@AndroidEntryPoint
open class BaseComponentAct : ComponentActivity() {

    lateinit var connectionLiveData: ConnectionLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        connectionLiveData = ConnectionLiveData(this@BaseComponentAct)
    }


    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    open fun BaseScaffold(
        topBar: @Composable () -> Unit = {},
        bottomBar: @Composable () -> Unit = {},
        content: @Composable BoxScope.() -> Unit
    ) {
        val isNetworkAvailable = connectionLiveData.observeAsState(true)
        val scaffoldState = rememberScaffoldState()
        Scaffold(
            topBar = topBar,
            bottomBar = bottomBar,
            scaffoldState = scaffoldState,
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                AnimatedVisibility(
                    visible = !isNetworkAvailable.value,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(.05f)
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxSize(),
                        backgroundColor = Color.White,
                        elevation = 3.dp,
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "No Internet Available",
                                color = Color.Red,
                                fontSize = 12.sp
                            )
                        }
                    }
                }
                Box(
                    modifier = Modifier.fillMaxSize(),
                    content = content
                )
            }
        }


    }


    @Composable
    fun BaseCollapsingToolbarScaffold(
        toolbar: @Composable CollapsingToolbarScope.() -> Unit,
        content: @Composable BoxScope.() -> Unit,
    ) {
        val isNetworkAvailable = connectionLiveData.observeAsState(true)
        val toolbarState = rememberCollapsingToolbarScaffoldState()
        CollapsingToolbarScaffold(
            modifier = Modifier,
            state = toolbarState,
            scrollStrategy = ScrollStrategy.EnterAlways,
            toolbar = toolbar
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                AnimatedVisibility(
                    visible = !isNetworkAvailable.value,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(.05f)
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxSize(),
                        backgroundColor = Color.White,
                        elevation = 3.dp,
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "No Internet Available",
                                color = Color.Red,
                                fontSize = 12.sp
                            )
                        }
                    }
                }
                Box(
                    modifier = Modifier.fillMaxSize(),
                    content = content
                )
            }

        }

    }


}