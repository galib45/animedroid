package com.galib.animedroid

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.remember
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*;
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults

@Composable
fun SearchField(
    modifier: Modifier = Modifier.fillMaxWidth(),
    text: String,
    onTextChange: (String) -> Unit,
    onCloseIconClick: () -> Unit,
    onSearch: () -> Unit
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
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search // Set IME action to Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = { 
                onSearch() // Handle the search action
            }
        ),
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
