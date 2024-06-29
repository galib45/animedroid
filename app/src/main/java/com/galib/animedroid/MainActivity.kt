package com.galib.animedroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import com.galib.animedroid.ui.theme.AppTheme

class MainActivity : ComponentActivity() { 
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val appName = getString(R.string.app_name)
        setContent {
            AppTheme {
               MainScreen(appName) 
            }
        }
    }
}

