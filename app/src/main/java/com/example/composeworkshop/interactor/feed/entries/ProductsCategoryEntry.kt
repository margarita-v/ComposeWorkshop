package com.example.composeworkshop.interactor.feed.entries

import com.example.composeworkshop.domain.ProductsCategoryEntity
import com.example.composeworkshop.interactor.Transformable
import kotlinx.serialization.Serializable

@Serializable
data class ProductsCategoryEntry(
    val name: String,
    val short_name: String,
    val icon: String
) : Transformable<ProductsCategoryEntity> {

    override fun transform() = ProductsCategoryEntity(name, short_name, icon)
}

@Serializable
data class ProductsCategoriesEntry(
    val categories: List<ProductsCategoryEntry>?
) : Transformable<List<ProductsCategoryEntity>> {

    override fun transform(): List<ProductsCategoryEntity> =
        categories?.map { it.transform() }.orEmpty()
}