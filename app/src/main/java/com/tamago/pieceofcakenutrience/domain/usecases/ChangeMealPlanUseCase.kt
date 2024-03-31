package com.tamago.pieceofcakenutrience.domain.usecases

import com.tamago.pieceofcakenutrience.domain.entity.Recipe
import com.tamago.pieceofcakenutrience.domain.repository.MealsRepository

/**
 * Created by Igor Khoroshun on 26.03.2024.
 */
class ChangeMealPlanUseCase(
    private val repository: MealsRepository
) {
    suspend fun addToMealsPlan(recipe: Recipe) = repository.addToMealPlan(recipe)
    suspend fun deleteFromMealsPlan(id: Int) = repository.deleteFromMealPlan(id)
}