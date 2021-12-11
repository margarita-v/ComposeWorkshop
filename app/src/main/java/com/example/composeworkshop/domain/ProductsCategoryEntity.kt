package com.example.composeworkshop.domain

import androidx.compose.runtime.Immutable

@Immutable
data class ProductsCategoryEntity(
    val name: String,
    val shortName: String,
    val icon: String
)