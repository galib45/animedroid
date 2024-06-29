package com.galib.animedroid

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class) 
@Composable
fun SearchBar(
    text: String,
    onTextChange: (String) -> Unit,
    onCloseIconClick: () -> Unit,
    onSearch: () -> Unit
) {
    Surface(
        modifier = Modifier
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
                onCloseIconClick = onCloseIconClick,
                onSearch = onSearch
            )
        }
    }
}


