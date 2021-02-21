package com.jeanbarrossilva.outdoor.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jeanbarrossilva.outdoor.ui.defaults.OutdoorTheme

val FormatButtonModifier = Modifier.padding(10.dp)

@Composable
fun TextEditorToolbarFormatIconButton(modifier: Modifier = Modifier, onClick: () -> Unit, content: @Composable () -> Unit) {
    OutdoorTheme.Wrap {
        IconButton(
            onClick,
            modifier
                .then(FormatButtonModifier),
            content = content
        )
    }
}