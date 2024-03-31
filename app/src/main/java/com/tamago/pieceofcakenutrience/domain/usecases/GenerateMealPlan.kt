package com.tamago.pieceofcakenutrience.domain.usecases

import com.tamago.pieceofcakenutrience.domain.repository.MealsRepository

/**
 * Created by Igor Khoroshun on 26.03.2024.
 */
class GenerateMealPlan(
    private val repository: MealsRepository
) {
    suspend fun generateMealPlan(query: String) = repository.generateMealPlan(query)
}