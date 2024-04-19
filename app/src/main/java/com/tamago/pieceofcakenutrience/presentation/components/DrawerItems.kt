package com.tamago.pieceofcakenutrience.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Created by Igor Khoroshun on 31.03.2024.
 */

@Composable
fun DrawerItems(
    text: String,
    icon: ImageVector? = null
){
    Row {
        if(icon != null) {
            Icon(imageVector = icon, contentDescription = "")
        }
        Text(text = text)
    }
}