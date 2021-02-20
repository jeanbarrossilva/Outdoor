package com.jeanbarrossilva.outdoor.ui.component

import androidx.compose.foundation.InteractionState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.jeanbarrossilva.outdoor.ui.defaults.OutdoorTheme

@Suppress("LocalVariableName")
@Composable
fun TextEditorToolbar(
    modifier: Modifier = Modifier,
    isShown: Boolean = true,
    text: String = "",
    onTextChange: (String) -> Unit,
    onTextSizeDecrease: () -> Unit,
    onTextSizeIncrease: () -> Unit,
    onBoldToggle: (Boolean) -> Unit,
    onAlignStart: () -> Unit,
    onJustify: () -> Unit,
    onCenter: () -> Unit,
    onAlignEnd: () -> Unit,
    layout: @Composable (Dp) -> Unit
) {
    // TODO: Replace hardcoded padding value by the real TextEditorToolbar height.
    val height by mutableStateOf(25.dp)

    var _isShown by remember { mutableStateOf(isShown) }
    var _text by remember { mutableStateOf(text) }

    val alpha = if (_isShown) 1f else 0f
    var isEditingTextSize by remember { mutableStateOf(false) }
    var isBold by remember { mutableStateOf(false) }

    OutdoorTheme.Fill(
        Modifier
            .clickable(interactionState = InteractionState(), indication = null) { _isShown = !_isShown }
    ) {
        layout(height)

        Card(
            modifier
                .alpha(alpha)
                .padding(10.dp)
                .align(Alignment.BottomCenter)
        ) {
            Column {
                LazyRow {
                    item {
                        TextSizeEditor(
                            text = _text,
                            isEditing = isEditingTextSize,
                            onToggleIcon = { isEditingTextSize = it },
                            onValueChange = {
                                _text = it
                                onTextChange(it)
                            }
                        )

                        TextSizeEditor(
                            onDecrease = onTextSizeDecrease,
                            onIncrease = onTextSizeIncrease
                        )

                        BoldButton(
                            isBold = isBold,
                            onToggle = onBoldToggle
                        )

                        AlignmentButtons(
                            onAlignStart = onAlignStart,
                            onJustify = onJustify,
                            onCenter = onCenter,
                            onAlignEnd = onAlignEnd
                        )
                    }
                }
            }
        }
    }
}