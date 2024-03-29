package com.tamago.pieceofcakenutrience.domain.repository

import com.tamago.pieceofcakenutrience.domain.entity.MealsPlan
import com.tamago.pieceofcakenutrience.domain.entity.Recipe
import com.tamago.pieceofcakenutrience.domain.entity.Templates
import com.tamago.pieceofcakenutrience.domain.entity.TimePeriod
import kotlinx.coroutines.flow.StateFlow

/**
 * Created by Igor Khoroshun on 26.03.2024.
 */
interface MealsRepository {
    fun searchRecipes(query: String): StateFlow<Set<Recipe>>
    suspend fun getRecipeInfo(id: Int): Recipe
    suspend fun generateMealPlan(query: String): MealsPlan
    suspend fun getMealPlan(query: String, timePeriod: TimePeriod): MealsPlan
    suspend fun addToMealPlan(recipe: Recipe): MealsPlan
    suspend fun deleteFromMealPlan(recipe: Recipe): MealsPlan
    suspend fun getMealTemplate(query: String): Templates
    suspend fun addMealTemplate(templates: Templates): Templates
    fun deleteFromMealPlan()
    fun deleteMealPlan()
}