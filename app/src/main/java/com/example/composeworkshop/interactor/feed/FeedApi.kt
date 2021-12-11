package com.example.composeworkshop.interactor.feed

import com.example.composeworkshop.interactor.feed.entries.ProductsCategoryEntry
import retrofit2.http.GET

interface FeedApi {

    @GET("user/feed/categories")
    suspend fun getCategories(): List<ProductsCategoryEntry>
}