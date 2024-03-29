package com.tamago.pieceofcakenutrience.domain.entity

/**
 * Created by Igor Khoroshun on 26.03.2024.
 */
data class MealsPlan(
    val id: Int,
    val title: String,
    val mealsPlan: Set<Recipe>
)
