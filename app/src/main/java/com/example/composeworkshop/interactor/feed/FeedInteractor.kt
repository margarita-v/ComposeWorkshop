package com.example.composeworkshop.interactor.feed

import com.example.composeworkshop.domain.ProductsCategoryEntity

class FeedInteractor(private val repository: FeedRepository) {

    suspend fun getCategories(): List<ProductsCategoryEntity> =
        repository.getCategories()
}