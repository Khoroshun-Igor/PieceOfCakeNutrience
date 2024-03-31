package com.tamago.pieceofcakenutrience.domain.usecases

import com.tamago.pieceofcakenutrience.domain.entity.TimePeriod
import com.tamago.pieceofcakenutrience.domain.repository.MealsRepository

/**
 * Created by Igor Khoroshun on 26.03.2024.
 */
class GetMealPlanUseCase(
    private val repository: MealsRepository
) {
    suspend fun getMealPlan(query: String, timePeriod: TimePeriod) =
        repository.getMealPlan(query, timePeriod)
}