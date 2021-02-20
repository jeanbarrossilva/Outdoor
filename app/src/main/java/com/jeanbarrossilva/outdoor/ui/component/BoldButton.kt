package com.jeanbarrossilva.outdoor.ui.component

import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FormatBold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BoldButton(modifier: Modifier = Modifier, isBold: Boolean, onToggle: (Boolean) -> Unit) {
    FormatIconToggleButton(
        modifier,
        isBold,
        onToggle
    ) {
        Icon(
            Icons.Rounded.FormatBold,
            contentDescription = "Bold"
        )
    }
}