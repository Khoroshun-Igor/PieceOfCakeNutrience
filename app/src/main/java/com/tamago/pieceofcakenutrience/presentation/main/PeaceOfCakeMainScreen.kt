package com.tamago.pieceofcakenutrience.presentation.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DismissibleNavigationDrawer
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.PieceOfCakeNutrienceTheme
import com.tamago.pieceofcakenutrience.R
import com.tamago.pieceofcakenutrience.domain.entity.Recipe
import com.tamago.pieceofcakenutrience.presentation.components.DrawerNavigationItem
import com.tamago.pieceofcakenutrience.presentation.components.RecipeCard
import kotlinx.coroutines.CoroutineScope

/**
 * Created by Igor Khoroshun on 31.03.2024.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier
){
    var query by remember {
        mutableStateOf("")
    }
    var active by remember {
        mutableStateOf(false)
    }
    var recipes = emptyList<Recipe>()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onPrimary)
    ) {
        SearchBar(
            query = query,
            onQueryChange = {
                query = it
            },
            onSearch = { active = false },
            active = active,
            onActiveChange = { active = it },
            placeholder = {
                Text(text = stringResource(R.string.search_recipe))
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.search)
                )
            }
        ){
            LazyVerticalGrid(columns = GridCells.Adaptive(minSize = dimensionResource(R.dimen.recipe_card_width))) {
                items(recipes){recipe ->
                    RecipeCard(recipe = recipe)
                }
            }
        }
    }
}
@Composable
fun PieceOfCakeMainScreen(
    modifier: Modifier = Modifier,
    drawerState: DrawerState = rememberDrawerState(DrawerValue.Closed)
) {
    val drawerState: DrawerState = drawerState
    val scope: CoroutineScope = rememberCoroutineScope()
    val items = listOf(
        DrawerNavigationItem.Home,
        DrawerNavigationItem.Favorite,
        DrawerNavigationItem.MealPlan,
        DrawerNavigationItem.SignOut
    )
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            Column(
                modifier = modifier
                    .background(MaterialTheme.colorScheme.onSecondary)
            ) {
                Column(
                    modifier = modifier
                        .width(dimensionResource(R.dimen.drawer_size))
                        .padding(dimensionResource(R.dimen.max_padding))
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = stringResource(R.string.avatar),
                            modifier = modifier
                                .padding(horizontal = dimensionResource(R.dimen.min_padding))
                                .size(dimensionResource(R.dimen.avatar_size))
                        )
                        Text(
                            stringResource(R.string.guest),
                            style = MaterialTheme.typography.headlineMedium,
                            modifier = modifier
                                .padding(horizontal = dimensionResource(R.dimen.min_padding))
                        )
                    }
                    HorizontalDivider(
                        modifier = modifier
                            .padding(dimensionResource(R.dimen.middle_padding))
                    )
                    items.forEach { item ->
                        if(item.text == R.string.sign_out){
                            Spacer(modifier = modifier.weight(1f))
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = stringResource(id = item.text),
                                modifier = modifier
                                    .padding(dimensionResource(R.dimen.min_padding))
                                    .size(dimensionResource(R.dimen.max_padding))
                            )
                            Text(
                                text = stringResource(item.text),
                                style = MaterialTheme.typography.headlineSmall,
                                modifier = modifier
                                    .padding(dimensionResource(R.dimen.min_padding))
                            )
                        }
                    }
                }
            }
        }
    ){
        MainScreen()
    }
}

@Preview
@Composable
fun MainScreenPreview(){
    PieceOfCakeNutrienceTheme {
        PieceOfCakeMainScreen()
    }
}

@Preview
@Composable
fun DrawlerPreview(){
    PieceOfCakeNutrienceTheme {
        PieceOfCakeMainScreen(drawerState = rememberDrawerState(DrawerValue.Open))
    }
}