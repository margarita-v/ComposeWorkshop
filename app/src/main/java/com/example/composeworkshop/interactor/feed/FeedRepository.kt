package com.example.composeworkshop.interactor.feed

import com.example.composeworkshop.domain.ProductsCategoryEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FeedRepository(private val api: FeedApi) {

    suspend fun getCategories(): List<ProductsCategoryEntity> =
        withContext(Dispatchers.IO) {
            api.getCategories().map { it.transform() }
        }
}