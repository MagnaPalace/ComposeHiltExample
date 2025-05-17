package com.example.composehiltexample.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composehiltexample.add.AddUserScreen
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MainScreen(
    navController: NavController = rememberNavController(),
    viewModel: MainViewModel = hiltViewModel()
) {
    val users = viewModel.users

    var isShowAddUserScreen by remember { mutableStateOf(false) }
    var isSlideUpVisible by remember { mutableStateOf(false) }
    var isHideAddUserScreen by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.getAllUsers()
    }

    LaunchedEffect(isShowAddUserScreen) {
        if (isShowAddUserScreen) {
            isSlideUpVisible = true
        }
    }

    LaunchedEffect(isHideAddUserScreen) {
        if (isHideAddUserScreen) {
            isSlideUpVisible = false
            delay(500)
            isShowAddUserScreen = false
            isHideAddUserScreen = false
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Main") },
                actions = {
                    IconButton(
                        onClick = {
                            isShowAddUserScreen = true
                        }
                    ) {
                        Icon(
                            Icons.Default.Add,
                            contentDescription = null,
                            modifier = Modifier.size(44.dp)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            users.forEach { user ->
                HorizontalDivider()
                Text(text = "${user.id}",
                    fontSize = 17.sp
                )
                Text(text = "${user.name}",
                    fontSize = 16.sp
                )
                Text(text = "${user.comment}",
                    fontSize = 14.sp
                )
                HorizontalDivider()
            }
        }
    }

    if (isShowAddUserScreen) {
        Box(
            modifier = Modifier.fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f))
                .navigationBarsPadding()
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {},
            contentAlignment = Alignment.BottomCenter
        ) {
            AnimatedVisibility(
                visible = isSlideUpVisible,
                enter = slideInVertically(
                    initialOffsetY = { fullHeight -> fullHeight },
                    animationSpec = tween(durationMillis = 500)
                ),
                exit = slideOutVertically(
                    targetOffsetY = { fullHeight -> fullHeight },
                    animationSpec = tween(durationMillis = 500)
                )
            ) {
                AddUserScreen(
                        onDismiss = { isHideAddUserScreen = true }
                )
            }
        }
    }
}