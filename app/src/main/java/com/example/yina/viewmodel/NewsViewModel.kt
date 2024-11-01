package com.example.yina.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yina.model.News
import com.example.yina.repo.NewsRepo
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {
    private val _newsRepo = NewsRepo()
    private val _news = MutableLiveData<MutableList<News>>()
    val news: LiveData<MutableList<News>> = _news
    private val _count = MutableLiveData(0)
    var count = _count

    init {
        getNews()
    }

     private fun getNews() {
        viewModelScope.launch {
            println("DebugPrint starting of data get")
            val result = _newsRepo.getNews()
            println("DebugPrint end of data get")
            _news.postValue(result)
//            _news.value = result
            println("DebugPrint end of data postValue")
        }
    }

    fun increment(): Unit {
        _count.value = (_count.value ?: 0) + 1
    }
}