package com.example.yina

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.yina.ui.theme.YInATheme
import com.example.yina.view.NewsListScreen
import com.example.yina.viewmodel.NewsViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val newsViewModel = ViewModelProvider(this)[NewsViewModel::class]
        super.onCreate(savedInstanceState)
        setContent {
            YInATheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NewsListScreen(newsViewModel)
                }
            }
        }
    }
}
