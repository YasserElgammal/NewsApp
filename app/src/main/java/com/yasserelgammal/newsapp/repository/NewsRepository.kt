package com.yasserelgammal.newsapp.repository

import com.yasserelgammal.newsapp.api.RetrofiInstance
import com.yasserelgammal.newsapp.database.ArticleDatabase
import com.yasserelgammal.newsapp.model.Article
import retrofit2.Retrofit

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofiInstance.api.getBreakingNews(countryCode,pageNumber)

    suspend fun searchNews(searchQuery:String, pageNumber: Int)=
        RetrofiInstance.api.searchNews(searchQuery,pageNumber)

    suspend fun upsert (article: Article) = db.getArticesDao().upsert(article)

    fun getSavedNews() = db.getArticesDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticesDao().deleteArticle(article)

}