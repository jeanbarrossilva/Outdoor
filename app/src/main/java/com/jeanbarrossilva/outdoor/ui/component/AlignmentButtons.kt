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
import androidx.compose.ui.text.style.TextAlign
import com.jeanbarrossilva.outdoor.extension.Extensions.isLtr
import com.jeanbarrossilva.outdoor.ui.defaults.OutdoorTheme

@Composable
fun AlignmentButtons(modifier: Modifier = Modifier, onAlignmentChange: (TextAlign) -> Unit) {
    val alignmentStartIcon = if (isLtr()) Icons.Rounded.FormatAlignLeft else Icons.Rounded.FormatAlignRight
    val alignmentEndIcon = if (isLtr()) Icons.Rounded.FormatAlignRight else Icons.Rounded.FormatAlignLeft

    OutdoorTheme.Wrap {
        Row(modifier) {
            FormatIconButton(onClick = { onAlignmentChange(TextAlign.Start) }) {
                Icon(
                    alignmentStartIcon,
                    contentDescription = "Text alignment start"
                )
            }

            FormatIconButton(onClick = { onAlignmentChange(TextAlign.Justify) }) {
                Icon(
                    Icons.Rounded.FormatAlignJustify,
                    contentDescription = "Text alignment justify"
                )
            }

            FormatIconButton(onClick = { onAlignmentChange(TextAlign.Center) }) {
                Icon(
                    Icons.Rounded.FormatAlignCenter,
                    contentDescription = "Text alignment center"
                )
            }

            FormatIconButton(onClick = { onAlignmentChange(TextAlign.End) }) {
                Icon(
                    alignmentEndIcon,
                    contentDescription = "Text alignment end"
                )
            }
        }
    }
}