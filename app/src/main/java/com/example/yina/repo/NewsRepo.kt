package com.example.yina.repo

import com.example.yina.model.News
import kotlinx.coroutines.delay

val newsList = mutableListOf(
    News(
        heading = "Global Market Update",
        desc = "Stock markets around the world saw a significant uptick today as reports indicate growth in multiple sectors.",
        imgUrl = "https://mf.b37mrtl.ru/rbthmedia/images/2020.10/article/5f9c121585600a79605e68d7.jpg"
    ),
    News(
        heading = "Technology Breakthrough",
        desc = "Scientists have developed a new method for faster data processing, which could change how AI handles information.",
        imgUrl = "https://mf.b37mrtl.ru/rbthmedia/images/2020.10/article/5f9c121585600a79605e68d7.jpg"
    ),

    News(
        heading = "Health and Wellness",
        desc = "Studies show a new diet could help improve overall health and reduce the risk of chronic diseases.",
        imgUrl = "https://mf.b37mrtl.ru/rbthmedia/images/2020.10/article/5f9c121585600a79605e68d7.jpg"
    ),
    News(
        heading = "Sports Update",
        desc = "The national football team advances to the finals after a stunning victory in last night's game.",
        imgUrl = "https://mf.b37mrtl.ru/rbthmedia/images/2020.10/article/5f9c121585600a79605e68d7.jpg"
    ),
    News(
        heading = "Entertainment Highlights",
        desc = "Upcoming blockbuster movies are set to release this month, promising a thrilling experience for audiences.",
        imgUrl = null  // No image available for this news item
    ),
    News(
        heading = "Entertainment Highlights",
        desc = "Upcoming blockbuster movies are set to release this month, promising a thrilling experience for audiences.",
        imgUrl = null  // No image available for this news item
    ),
    News(
        heading = "Entertainment Highlights",
        desc = "Upcoming blockbuster movies are set to release this month, promising a thrilling experience for audiences.",
        imgUrl = null  // No image available for this news item
    ),
    News(
        heading = "Entertainment Highlights",
        desc = "Upcoming blockbuster movies are set to release this month, promising a thrilling experience for audiences.",
        imgUrl = null  // No image available for this news item
    ),
    News(
        heading = "Entertainment Highlights",
        desc = "Upcoming blockbuster movies are set to release this month, promising a thrilling experience for audiences.",
        imgUrl = null  // No image available for this news item
    ),
    News(
        heading = "Entertainment Highlights",
        desc = "Upcoming blockbuster movies are set to release this month, promising a thrilling experience for audiences.",
        imgUrl = null  // No image available for this news item
    )
)

class NewsRepo {
    suspend fun getNews(): MutableList<News> {
        delay(1000)
        return newsList
    }
}