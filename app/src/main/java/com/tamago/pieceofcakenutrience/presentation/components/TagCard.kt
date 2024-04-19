package com.tamago.pieceofcakenutrience.presentation.components

import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tamago.pieceofcakenutrience.domain.entity.RecipeInfo

/**
 * Created by Igor Khoroshun on 09.04.2024.
 */

@Composable
fun TagCard(
    recipeInfo: RecipeInfo,
    modifier: Modifier = Modifier
){
    val tagList: List<Boolean> = emptyList()

    tagList.forEach{
        if(it){
            Card {
                Text(text = it.toString())
            }
        }
    }
}