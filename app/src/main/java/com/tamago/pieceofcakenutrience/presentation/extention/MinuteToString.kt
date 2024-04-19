package com.tamago.pieceofcakenutrience.presentation.extention

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.tamago.pieceofcakenutrience.R

/**
 * Created by Igor Khoroshun on 17.04.2024.
 */


@Composable
fun Int.MinuteToString() = this.toString() + " " + stringResource(R.string.minutes)