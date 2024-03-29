package com.tamago.pieceofcakenutrience.domain.entity

/**
 * Created by Igor Khoroshun on 26.03.2024.
 */
data class Recipe(
    val id: Int,
    val title: String,
    val image: String,
    val recipeInfo: RecipeInfo
)
