package com.tamago.pieceofcakenutrience.domain.usecases

import com.tamago.pieceofcakenutrience.domain.repository.MealsRepository

/**
 * Created by Igor Khoroshun on 26.03.2024.
 */
class SearchRecipesUseCase(
    private val repository: MealsRepository
) {
    suspend fun getRecipes(query: String) = repository.searchRecipes(query)
    suspend fun getRecipeInfo(id: Int) = repository.getRecipeInfo(id)
}