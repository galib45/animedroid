package com.galib.animedroid

import android.util.Log
import kotlinx.coroutines.launch
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.core.tween

@Composable
fun MainScreen(appName: String) {
    val scope = rememberCoroutineScope()
    var isSearchBarVisible by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("") }
    var displayText by remember { mutableStateOf("") }
    Scaffold(topBar = {
        AppBar(appName, onSearchIconClick = { isSearchBarVisible = true })
        AnimatedVisibility(
            visible = isSearchBarVisible,
            enter = expandHorizontally(animationSpec = tween(durationMillis = 500)) + fadeIn(animationSpec = tween(durationMillis = 500)),
            exit = shrinkHorizontally(animationSpec = tween(durationMillis = 500)) + fadeOut(animationSpec = tween(durationMillis = 500))
        ) {
            SearchBar(
                text, onTextChange = { text = it }, 
                onCloseIconClick = {
                    if (text.isNotEmpty()) text = ""
                    else isSearchBarVisible = false
                }, onSearch = {
                    if (text.isNotEmpty()) {
                        val animeName = text
                        text = ""; isSearchBarVisible = false
                        displayText = "Searching for \"$animeName\""
                        // Log.i(appName, displayText)
                        scope.launch { 
                            displayText = searchAnime(animeName)
                            // Log.i(appName, displayText)
                        }
                    }
                }
            )
        }
    }) { innerPadding ->
        Row(
            modifier = Modifier.padding(innerPadding).fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(displayText)
        }
    }
}
