package com.example.vecelconfbadge.extentions

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.sp

val Int.nonSp
    @Composable
    get() = LocalDensity.current.let { this / it.fontScale }.sp