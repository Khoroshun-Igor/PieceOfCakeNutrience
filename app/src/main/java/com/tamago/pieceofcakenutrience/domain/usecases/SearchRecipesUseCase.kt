package com.tamago.pieceofcakenutrience.domain.usecases

import com.tamago.pieceofcakenutrience.domain.entity.Recipe
import com.tamago.pieceofcakenutrience.domain.repository.MealsRepository
import kotlinx.coroutines.flow.StateFlow

/**
 * Created by Igor Khoroshun on 26.03.2024.
 */
class SearchRecipesUseCase(
    private val repository: MealsRepository
) {
    fun getRecipes(query: String): StateFlow<Set<Recipe>>{
        return repository.searchRecipes(query)
    }
}