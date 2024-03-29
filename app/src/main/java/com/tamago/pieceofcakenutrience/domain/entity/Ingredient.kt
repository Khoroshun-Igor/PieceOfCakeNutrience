package com.tamago.pieceofcakenutrience.domain.entity

/**
 * Created by Igor Khoroshun on 29.03.2024.
 */
data class Ingredient(
    val name: String,
    val image: String,
    val amount: java.math.BigDecimal,
    val unit: String
)
