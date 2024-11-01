package com.example.yina.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yina.model.News
import com.example.yina.repo.NewsRepo
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {
    private val newsRepo = NewsRepo()
    private val _news = MutableLiveData<MutableList<News>>()
     val news : LiveData<MutableList<News>> = _news

    init {
        viewModelScope.launch {
            val result = newsRepo.getNews()
            _news.postValue(result)
        }

    }
}