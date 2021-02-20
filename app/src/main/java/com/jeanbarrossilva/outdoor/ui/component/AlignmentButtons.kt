package com.jeanbarrossilva.outdoor.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FormatAlignCenter
import androidx.compose.material.icons.rounded.FormatAlignJustify
import androidx.compose.material.icons.rounded.FormatAlignLeft
import androidx.compose.material.icons.rounded.FormatAlignRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jeanbarrossilva.outdoor.extension.Extensions.isLtr
import com.jeanbarrossilva.outdoor.ui.defaults.OutdoorTheme

@Composable
fun AlignmentButtons(modifier: Modifier = Modifier, onAlignStart: () -> Unit, onJustify: () -> Unit, onCenter: () -> Unit, onAlignEnd: () -> Unit) {
    val alignmentStartIcon = if (isLtr()) Icons.Rounded.FormatAlignLeft else Icons.Rounded.FormatAlignRight
    val alignmentEndIcon = if (isLtr()) Icons.Rounded.FormatAlignRight else Icons.Rounded.FormatAlignLeft

    OutdoorTheme.Wrap {
        Row(modifier) {
            FormatIconButton(onClick = onAlignStart) {
                Icon(
                    alignmentStartIcon,
                    contentDescription = "Text alignment start"
                )
            }

            FormatIconButton(onClick = onJustify) {
                Icon(
                    Icons.Rounded.FormatAlignJustify,
                    contentDescription = "Text alignment justify"
                )
            }

            FormatIconButton(onClick = onCenter) {
                Icon(
                    Icons.Rounded.FormatAlignCenter,
                    contentDescription = "Text alignment center"
                )
            }

            FormatIconButton(onClick = onAlignEnd) {
                Icon(
                    alignmentEndIcon,
                    contentDescription = "Text alignment end"
                )
            }
        }
    }
}