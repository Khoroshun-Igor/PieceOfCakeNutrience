package com.tamago.pieceofcakenutrience.domain.entity

/**
 * Created by Igor Khoroshun on 29.03.2024.
 */
data class RecipeInfo (
    val readyInMinutes: Int,
    val sourceUrl: String,
    val spoonacularScore: java.math.BigDecimal,
    val cheap: Boolean,
    val cuisines: List<String>,
    val dairyFree: Boolean,
    val diets: List<String>,
    val gaps: String,
    val glutenFree: Boolean,
    val instructions: String,
    val ketogenic: Boolean,
    val lowFodmap: Boolean,
    val vegan: Boolean,
    val vegetarian: Boolean,
    val veryHealthy: Boolean,
    val dishTypes: List<String>,
    val extendedIngredients: kotlin.collections.Set<Ingredient>,
)