package com.galib.animedroid

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*;
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.LaunchedEffect

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.core.tween

import com.galib.animedroid.ui.theme.AnimeDroidTheme

class MainActivity : ComponentActivity() { 
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimeDroidTheme {
                val appName = getString(R.string.app_name);
                var isSearchBarVisible by remember { mutableStateOf(false) }
                var text by remember { mutableStateOf("") }
                Scaffold(topBar = {
                    AppBar(appName, onSearchIconClick = { isSearchBarVisible = true })
                    AnimatedVisibility(
                        visible = isSearchBarVisible,
                        enter = expandHorizontally(),
                        exit = shrinkHorizontally()
                    ) {
                        SearchBar(
                            text, { text = it }, 
                            onCloseIconClick = {
                                if (text.isNotEmpty()) text = ""
                                else isSearchBarVisible = false
                            }
                        )
                    }
                }) { innerPadding ->
                    Row(
                        modifier = Modifier.padding(innerPadding).fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text, fontSize = 24.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun AppBar(
    appName: String, 
    onSearchIconClick: () -> Unit
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(appName)
        },
        actions = {
            IconButton(onClick = onSearchIconClick) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "Search"
                )
            }
        },
    )
}

@Composable
fun SearchBar(
    text: String,
    onTextChange: (String) -> Unit,
    onCloseIconClick: () -> Unit,
) {
    Surface(
        modifier = Modifier
            //.background(color = Color.Transparent)
            .windowInsetsPadding(TopAppBarDefaults.windowInsets)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .height(64.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            SearchField(
                text = text, 
                onTextChange = onTextChange,
                onCloseIconClick = onCloseIconClick
            )
        }
    }
}

@Composable
fun SearchField(
    modifier: Modifier = Modifier.fillMaxWidth(),
    text: String,
    onTextChange: (String) -> Unit,
    onCloseIconClick: () -> Unit,
) {
    val focusRequester = remember { FocusRequester() }
    
    TextField(
        modifier = modifier.focusRequester(focusRequester),
        value = text,
        onValueChange = onTextChange,
        singleLine = true,
        leadingIcon = { 
            Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = "Search"
            )
        },
        trailingIcon = { 
            IconButton(onClick = onCloseIconClick) {
                Icon(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = "Close"
                )
            }
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            errorContainerColor = Color.Transparent,
            cursorColor = Color.White
        )
    )

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
}