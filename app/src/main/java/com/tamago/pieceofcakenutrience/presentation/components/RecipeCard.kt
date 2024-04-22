package com.tamago.pieceofcakenutrience.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.PieceOfCakeNutrienceTheme
import com.tamago.pieceofcakenutrience.R
import com.tamago.pieceofcakenutrience.domain.entity.Recipe
import com.tamago.pieceofcakenutrience.domain.entity.RecipeInfo

/**
 * Created by Igor Khoroshun on 01.04.2024.
 */

@Composable
fun RecipeCard(
    recipe: Recipe,
    modifier: Modifier = Modifier
){
    var showMore by remember {
        mutableStateOf(false)
    }
    var isFavorite by remember {
        mutableStateOf(false)
    }
    var isAdded by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = modifier
            .width(dimensionResource(R.dimen.recipe_card_width))
    ){
        Column(
            modifier = modifier
                .background(MaterialTheme.colorScheme.onPrimary)
                .padding(dimensionResource(R.dimen.min_padding))
        ) {
            Box(
                contentAlignment = Alignment.TopCenter,
            ) {
                Image(
                    painter = painterResource(R.drawable.pasta),
                    contentDescription = "",
                    modifier = modifier
                        .size(
                            dimensionResource(R.dimen.recipe_image_size)
                        ),
                    contentScale = ContentScale.Crop
                )
                Row(
                    verticalAlignment = Alignment.Top,
                    modifier = modifier
                        .padding(dimensionResource(R.dimen.min_padding))
                ) {
                    IconButton(
                        onClick = {
                            isAdded = !isAdded
                            /*TODO*/
                        },
                        modifier = modifier
                            .clip(RoundedCornerShape(dimensionResource(R.dimen.max_padding)))
                            .background(MaterialTheme.colorScheme.onPrimary)
                            .size(dimensionResource(R.dimen.icon_size)),
                        content = {
                            when {
                                !isAdded -> Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = stringResource(R.string.add_to_favorite),
                                    tint = MaterialTheme.colorScheme.primary,
                                )

                                isAdded -> Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = stringResource(R.string.delete_from_favorite),
                                    tint = MaterialTheme.colorScheme.primary,
                                )
                            }
                        }
                    )
                    Spacer(modifier = modifier.weight(1f))
                    IconButton(
                        onClick = {
                            isFavorite = !isFavorite
                            /*TODO*/
                        },
                        modifier = modifier
                            .clip(RoundedCornerShape(dimensionResource(R.dimen.max_padding)))
                            .background(MaterialTheme.colorScheme.onPrimary)
                            .size(dimensionResource(R.dimen.icon_size)),
                        content = {
                            when {
                                !isFavorite -> Icon(
                                    imageVector = Icons.Default.FavoriteBorder,
                                    contentDescription = stringResource(R.string.add_to_favorite),
                                    tint = MaterialTheme.colorScheme.error,
                                )

                                isFavorite -> Icon(
                                    imageVector = Icons.Default.Favorite,
                                    contentDescription = stringResource(R.string.delete_from_favorite),
                                    tint = MaterialTheme.colorScheme.error,
                                )
                            }
                        }
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        vertical = dimensionResource(R.dimen.min_padding)
                    )
            ) {
                Column(
                    modifier = modifier.width(dimensionResource(R.dimen.text_width))
                ) {
                    Text(
                        text = recipe.title,
                        color = MaterialTheme.colorScheme.primary,
                        softWrap = true
                    )
                }
                Spacer(modifier = modifier.weight(1f))
                Card(
                    colors = CardColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary,
                        disabledContentColor = MaterialTheme.colorScheme.secondary,
                        disabledContainerColor = MaterialTheme.colorScheme.onSecondary
                    )
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = modifier
                            .padding(dimensionResource(R.dimen.min_padding))
                    ) {
                        Text(
                            text = recipe.recipeInfo.readyInMinutes.toString(),
                        )
                        Text(
                            text = stringResource(R.string.minutes),
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
                Card(
                    modifier = modifier
                        .padding(
                            start = dimensionResource(R.dimen.min_padding)
                        ),
                    colors = CardColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary,
                        disabledContentColor = MaterialTheme.colorScheme.secondary,
                        disabledContainerColor = MaterialTheme.colorScheme.onSecondary
                    )
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = modifier
                            .padding(
                                horizontal = dimensionResource(id = R.dimen.min_padding)
                            )
                    ) {
                        Text(
                            text = recipe.recipeInfo.spoonacularScore.toString(),
                        )
                        Text(
                            text = stringResource(R.string.score),
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                }
            }
            if(showMore){
                TODO()
            }
        }
    }
}

@Preview
@Composable
fun RecipeCardPreview(){
    PieceOfCakeNutrienceTheme {
        RecipeCard(
            recipe = Recipe(
                0,
                "Pasta with spicy salmon in Japanese style",
                "" +
                        "",
                recipeInfo = RecipeInfo(
                    0,
                    "",
                    99.5.toBigDecimal(),
                    false,
                    listOf(""),
                    false,
                    listOf(""),
                    "",
                    false,
                    "",
                    false,
                    false,
                    false,
                    false,
                    false,
                    listOf(""),
                    emptySet()
                )
            )
        )
    }
}