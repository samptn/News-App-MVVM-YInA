package com.example.yina

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import coil3.compose.AsyncImage
import com.example.yina.model.News
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


@Composable
fun NewsCard(news: News) {
    Column(
        modifier = Modifier
            .padding(16.dp, 8.dp)
            .shadow(
                16.dp
            )
            .clip(
                RoundedCornerShape(16.dp)
            )
            .background(
                Color.White
            ),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            news.imgUrl?.let {
                AsyncImage(
                    model = it,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(
                            220.dp
                        )
                        .padding(
                            bottom = 16.dp
                        )
                        .clip(
                            RoundedCornerShape(16.dp)
                        ),
                    contentScale = ContentScale.FillBounds
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        bottom = 16.dp
                    )
            ) {
                Text(
                    text = news.heading,
                    style = TextStyle(
                        fontWeight = FontWeight.W700,
                        fontSize = 18.sp,
                    ),
                )
                Text(
                    text = "12th Jan, 04:30 PM",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W300,
                    ),
                )
            }
            Text(
                text = news.desc,
                style = TextStyle(
                    fontWeight = FontWeight.W400,
                    fontSize = 16.sp,
                )
            )
        }
    }
}