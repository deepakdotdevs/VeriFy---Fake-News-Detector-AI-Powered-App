package com.verify.newsai.data.model

data class NewsResponse(
    val status:String, // that means whether the response is ok or not
    val totalResults:Int, // that means total number of articles
    val articles: List<Article> // that means list of articles
)