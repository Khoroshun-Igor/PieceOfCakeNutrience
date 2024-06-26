package com.tamago.pieceofcakenutrience.domain.usecases

import com.tamago.pieceofcakenutrience.domain.repository.MealsRepository

/**
 * Created by Igor Khoroshun on 26.03.2024.
 */
class DeleteMealPlanUseCase(
    private val repository: MealsRepository
) {
    suspend fun deleteMealPlan(id: Int) = repository.deleteMealPlan(id)
}