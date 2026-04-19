package com.verify.newsai.data.api

import com.verify.newsai.data.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("v2/top-headlines") // coz we are getting top headlines
    suspend fun getTopHeadlines(
        @Query("country") country: String = "us", // means this line shows us the news of US
        @Query("page") page:Int,
        @Query("apiKey") apiKey: String
    ): Response<NewsResponse>
}