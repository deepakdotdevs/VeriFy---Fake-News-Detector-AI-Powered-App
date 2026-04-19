package com.verify.newsai.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.verify.newsai.data.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class NewsViewModel @Inject constructor(
    private val repository: NewsRepository
): ViewModel() {
//    fun fetchNews() {
//        Log.d("TEST", "fetchNews called")
//        viewModelScope.launch {
//            val response = repository.getNews(1, "625f0b6194c548ed9381a6d09d6ff0c6")
//            if(response.isSuccessful) {
//                Log.d("NEWS_DATA", response.body().toString())
//            } else {
//                Log.e("NEWS_ERROR", response.errorBody().toString())
//            }
//
//        }
//    }

    fun fetchNews() {
        viewModelScope.launch {

            Log.d("TEST", "API CALL STARTED")

            val response = repository.getNews(1, "625f0b6194c548ed9381a6d09d6ff0c6")

            if (response.isSuccessful) {
                Log.d("NEWS_DATA", response.body().toString())
            } else {
                Log.e("NEWS_ERROR", response.errorBody()?.string() ?: "error")
            }
        }
    }
}