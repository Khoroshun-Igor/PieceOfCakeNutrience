package com.tamago.pieceofcakenutrience.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.tamago.pieceofcakenutrience.R

/**
 * Created by Igor Khoroshun on 19.04.2024.
 */
sealed class DrawerNavigationItem(
    val icon: @Composable ()->Unit,
    val text: @Composable ()->Unit,
) {
    object Home: DrawerNavigationItem(
        icon = {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = stringResource(R.string.home)
            )
        },
        text = {
            Text(
                text = stringResource(R.string.home)
            )
        }
    )
    object Favorite: DrawerNavigationItem(
        icon = {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = stringResource(R.string.favorite)
            )
        },
        text = {
            Text(
                text = stringResource(R.string.favorite)
            )
        }
    )
    object MealPlan: DrawerNavigationItem(
        icon = {
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = stringResource(R.string.my_meal_plan)
            )
        },
        text = {
            Text(
                text = stringResource(R.string.my_meal_plan)
            )
        }
    )
    object SignOut: DrawerNavigationItem(
        icon = {
            Icon(
                imageVector = Icons.AutoMirrored.Default.ExitToApp,
                contentDescription = stringResource(R.string.sign_out)
            )
        },
        text = {
            Text(
                text = stringResource(R.string.sign_out)
            )
        }
    )
}