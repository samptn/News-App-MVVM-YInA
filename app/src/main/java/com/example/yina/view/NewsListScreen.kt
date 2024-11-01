package com.example.yina.view

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.yina.NewsCard
import com.example.yina.viewmodel.NewsViewModel

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
