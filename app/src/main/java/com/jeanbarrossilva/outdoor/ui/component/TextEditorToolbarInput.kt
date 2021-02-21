package com.jeanbarrossilva.outdoor.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.TextFormat
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jeanbarrossilva.outdoor.ui.defaults.OutdoorTheme

@Composable
fun TextEditorToolbarInput(
    modifier: Modifier = Modifier,
    text: String,
    isEditing: Boolean,
    onToggleIcon: (Boolean) -> Unit,
    onValueChange: (String) -> Unit
) {
    OutdoorTheme.Wrap {
        Row(modifier) {
            TextEditorToolbarFormatIconToggleButton(
                isChecked = isEditing,
                onToggle = onToggleIcon
            ) {
                Icon(
                    Icons.Rounded.TextFormat,
                    contentDescription = "Text"
                )
            }

            if (isEditing)
                TextField(
                    text,
                    onValueChange,
                    Modifier
                        .widthIn(max = 200.dp)
                        .wrapContentWidth(),
                    singleLine = true
                )
        }
    }
}