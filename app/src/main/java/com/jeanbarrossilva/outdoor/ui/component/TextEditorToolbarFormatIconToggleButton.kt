package com.jeanbarrossilva.outdoor.ui.component

import androidx.compose.material.IconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jeanbarrossilva.outdoor.ui.defaults.OutdoorTheme

@Composable
fun TextEditorToolbarFormatIconToggleButton(
    modifier: Modifier = Modifier,
    isChecked: Boolean,
    onToggle: (Boolean) -> Unit,
    content: @Composable () -> Unit
) {
    OutdoorTheme.Wrap {
        IconToggleButton(
            checked = isChecked,
            onCheckedChange = { onToggle(it) },
            modifier
                .then(FormatButtonModifier),
            content = content
        )
    }
}