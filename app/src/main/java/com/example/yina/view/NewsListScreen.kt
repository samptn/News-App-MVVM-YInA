package com.example.yina.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.yina.model.News
import com.example.yina.viewmodel.NewsViewModel

@Composable
fun NewsListScreen(newsViewModel: NewsViewModel) {
    val news = newsViewModel.news.observeAsState()
    val count = newsViewModel.count.observeAsState()
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    4.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                onClick = {
                    newsViewModel.increment()
                }, modifier = Modifier.padding(0.dp)

            ) {
                Icon(
                    imageVector = Icons.Default.Menu, contentDescription = "Menu"
                )
            }
            Text(
                text = "TEST MVVM ${count.value}",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W700,
                    fontStyle = FontStyle.Italic,
                    color = Color.Red,
                ),
            )
            IconButton(
                onClick = {
                    newsViewModel.increment()
                }, modifier = Modifier.padding(0.dp)

            ) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notifications",
                )
            }
        }
        LazyColumn {
            news.value?.let { newsItems ->
                items(
                    newsItems.size
                ) {
                    NewsCard(news = newsItems[it])
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
            modifier = Modifier.padding(16.dp)
        ) {
            news.imgUrl?.let {
                Box {
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
                    IconButton(
                        onClick = {

                        }, modifier = Modifier.align(
                            Alignment.TopEnd
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Share, modifier = Modifier
                                .background(
                                    Color.White, CircleShape
                                )
                                .padding(4.dp),
                            contentDescription = "Share",
                            tint = Color.Magenta

                        )
                    }
                }
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
                news.uploadedAt?.let {
                    Text(
                        text = it,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W300,
                        ),
                    )
                }
            }
            Text(
                text = news.desc, style = TextStyle(
                    fontWeight = FontWeight.W400,
                    fontSize = 16.sp,
                )
            )
        }
    }
}