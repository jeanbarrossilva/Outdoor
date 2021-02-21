package com.jeanbarrossilva.outdoor.ui.component

import android.app.Activity
import androidx.compose.foundation.InteractionState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowInsetsCompat.Type.systemBars
import androidx.core.view.WindowInsetsControllerCompat
import com.jeanbarrossilva.outdoor.ui.defaults.OutdoorTheme

@Suppress("LocalVariableName")
@Composable
fun TextEditorToolbar(
    modifier: Modifier = Modifier,
    activity: Activity,
    isShown: Boolean = true,
    getsHiddenOnOutsideFocus: Boolean = true,
    text: String = "",
    onTextChange: (String) -> Unit,
    onTextSizeDecrease: () -> Unit,
    onTextSizeIncrease: () -> Unit,
    onBoldToggle: (Boolean) -> Unit,
    onAlignmentChange: (TextAlign) -> Unit,
    layout: @Composable (Dp) -> Unit
) {
    val windowInsetsControllerCompat = WindowInsetsControllerCompat(activity.window, LocalView.current)

    // TODO: Replace hardcoded padding value by the real TextEditorToolbar height.
    val height by mutableStateOf(25.dp)

    var _isShown by remember { mutableStateOf(isShown) }
    var _text by remember { mutableStateOf(text) }

    val alpha = if (_isShown) 1f else 0f
    var isEditingText by remember { mutableStateOf(false) }
    var isBold by remember { mutableStateOf(false) }

    OutdoorTheme.Fill {
        Box(
            Modifier
                .clickable(interactionState = InteractionState(), indication = null) {
                    if (getsHiddenOnOutsideFocus) {
                        _isShown = !_isShown
                        with(windowInsetsControllerCompat) { if (_isShown) show(systemBars()) else hide(systemBars()) }
                    }
                }
                .fillMaxSize()
        ) {
            layout(height)
        }

        Card(
            modifier
                .alpha(alpha)
                .padding(10.dp)
                .align(Alignment.BottomCenter)
        ) {
            Column {
                LazyRow {
                    item {
                        TextEditorToolbarInput(
                            text = _text,
                            isEditing = isEditingText,
                            onToggleIcon = { isEditingText = it },
                            onValueChange = {
                                _text = it
                                onTextChange(it)
                            }
                        )

                        TextEditorToolbarTextSizeButtons(
                            onDecrease = onTextSizeDecrease,
                            onIncrease = onTextSizeIncrease
                        )

                        TextEditorToolbarBoldButton(
                            isBold = isBold,
                            onToggle = {
                                isBold = it
                                onBoldToggle(it)
                            }
                        )

                        AlignmentButtons(onAlignmentChange = onAlignmentChange)
                    }
                }
            }
        }
    }
}