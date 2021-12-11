package com.example.composeworkshop.interactor.feed.entries

import com.example.composeworkshop.domain.ProductsCategoryEntity
import com.example.composeworkshop.interactor.Transformable
import kotlinx.serialization.Serializable

@Serializable
data class ProductsCategoryEntry(
    val name: String
) : Transformable<ProductsCategoryEntity> {

    override fun transform() = ProductsCategoryEntity(name)
}