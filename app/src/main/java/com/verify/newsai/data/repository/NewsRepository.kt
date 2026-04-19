package com.verify.newsai.data.repository

import com.verify.newsai.data.api.NewsApiService
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val api: NewsApiService
) {
    suspend fun getNews(page:Int, apiKey:String) =
        api.getTopHeadlines(page=page, apiKey = apiKey)
}