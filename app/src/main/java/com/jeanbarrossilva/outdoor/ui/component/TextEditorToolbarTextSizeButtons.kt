package com.jeanbarrossilva.outdoor.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ZoomIn
import androidx.compose.material.icons.rounded.ZoomOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jeanbarrossilva.outdoor.ui.defaults.OutdoorTheme

@Composable
fun TextEditorToolbarTextSizeButtons(modifier: Modifier = Modifier, onDecrease: () -> Unit, onIncrease: () -> Unit) {
    OutdoorTheme.Wrap {
        Row(modifier) {
            TextEditorToolbarFormatIconButton(onClick = onDecrease) {
                Icon(
                    Icons.Rounded.ZoomOut,
                    contentDescription = "Decrease text size"
                )
            }

            TextEditorToolbarFormatIconButton(onClick = onIncrease) {
                Icon(
                    Icons.Rounded.ZoomIn,
                    contentDescription = "Increase text size"
                )
            }
        }
    }
}