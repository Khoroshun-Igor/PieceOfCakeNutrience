package com.tamago.pieceofcakenutrience.presentation.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DismissibleDrawerSheet
import androidx.compose.material3.DismissibleNavigationDrawer
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
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
import androidx.compose.ui.res.stringResource
import com.tamago.pieceofcakenutrience.R
import com.tamago.pieceofcakenutrience.presentation.components.DrawerItems
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

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
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        SearchBar(
            query = query,
            onQueryChange = {
                query = it
            },
            onSearch = { active = false },
            active = active,
            onActiveChange = { active = it },
            modifier = modifier
                .align(Alignment.TopCenter),
            placeholder = {
                Text(text = stringResource(R.string.search_recipe))
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.search)
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = stringResource(R.string.filters))
            }
        ){
            TODO()
        }
    }
}
@Composable
fun PeaceOfCakeMainScreen(
    modifier: Modifier = Modifier
) {
    val drawerState: DrawerState = rememberDrawerState(DrawerValue.Closed)
    val scope: CoroutineScope = rememberCoroutineScope()
    val items = listOf(
        DrawerItems(
            text = stringResource(R.string.search),
            icon = Icons.Filled.Search
        ),
        DrawerItems(
            text = stringResource(R.string.my_meal_plan),
            icon = Icons.Filled.DateRange
        )
    )
    val selectedItem = remember {
        mutableStateOf(items[0])
    }
    DismissibleNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DismissibleDrawerSheet {
                Column(
                    modifier = modifier.verticalScroll(rememberScrollState())
                ) {
                    Image(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = stringResource(R.string.avatar)
                    )
                    Text(
                        stringResource(R.string.guest)
                    )
                    items.forEach { item ->
                        NavigationDrawerItem(
                            label = { /*TODO*/ },
                            selected = item == selectedItem.value,
                            onClick = {
                                scope.launch {
                                    drawerState.close()
                                    selectedItem.value = item
                                }
                            }
                        )
                    }
                }
            }
        },
        content = {
            MainScreen()
        }
    )
}