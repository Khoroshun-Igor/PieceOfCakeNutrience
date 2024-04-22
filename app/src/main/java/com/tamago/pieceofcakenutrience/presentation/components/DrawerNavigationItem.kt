package com.tamago.pieceofcakenutrience.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.tamago.pieceofcakenutrience.R

/**
 * Created by Igor Khoroshun on 19.04.2024.
 */
sealed class DrawerNavigationItem(
    val icon: ImageVector,
    val text: Int,
) {
    object Home: DrawerNavigationItem(
        icon =  Icons.Default.Home,
        text =  R.string.home
    )
    object Favorite: DrawerNavigationItem(
        icon =  Icons.Default.Favorite,
        text = R.string.favorite
    )
    object MealPlan: DrawerNavigationItem(
        icon = Icons.Default.DateRange,
        text = R.string.my_meal_plan
    )
    object SignOut: DrawerNavigationItem(
        icon = Icons.AutoMirrored.Default.ExitToApp,
        text = R.string.sign_out
    )
}