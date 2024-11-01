package com.example.yina

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
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
fun NewsListScreen(newsViewModel: NewsViewModel) {
    val news = newsViewModel.news.observeAsState()

    LazyColumn(
        modifier = Modifier.padding(
            top = 16.dp
        )
    ) {
        news.value?.let { newsItems ->
            items(
                newsItems.size
            ) {
                NewsCard(news = newsItems[it])
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

            Text(
                text = news.heading,
                style = TextStyle(
                    fontWeight = FontWeight.W700,
                    fontSize = 18.sp,
                ),
                modifier = Modifier.padding(
                    bottom = 16.dp
                )
            )
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