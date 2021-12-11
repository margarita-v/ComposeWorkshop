package com.example.composeworkshop.interactor.feed

import com.example.composeworkshop.interactor.feed.entries.ProductsCategoriesEntry
import retrofit2.http.GET

interface FeedApi {

    @GET("user/feed/categories")
    suspend fun getCategories(): ProductsCategoriesEntry
}