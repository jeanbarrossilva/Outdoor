package com.jeanbarrossilva.outdoor.ui

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jeanbarrossilva.outdoor.extension.SaverX.TextUnitMutableStateSaver
import com.jeanbarrossilva.outdoor.extension.TextUnitX.minus
import com.jeanbarrossilva.outdoor.extension.TextUnitX.plus
import com.jeanbarrossilva.outdoor.ui.component.TextEditorToolbar
import com.jeanbarrossilva.outdoor.ui.defaults.OutdoorTheme

@Composable
fun MessageUI(
    modifier: Modifier = Modifier,
    activity: Activity,
    message: String = "Tap the text icon below and type something! You can also tap anywhere to hide the toolbar."
) {
    @Suppress("LocalVariableName")
    var _message by rememberSaveable { mutableStateOf(message) }

    var size by rememberSaveable(saver = TextUnitMutableStateSaver) { mutableStateOf(14.sp) }
    var isBold by rememberSaveable { mutableStateOf(false) }
    var alignment by rememberSaveable { mutableStateOf(TextAlign.Center) }

    val color = if (isSystemInDarkTheme()) Color.White else Color.Black
    val sizeDiff = 2.5.sp
    val weight = if (isBold) FontWeight.Bold else FontWeight.Normal

    OutdoorTheme.Fill {
        TextEditorToolbar(
            Modifier
                .align(Alignment.BottomCenter),
            activity,
            text = message,
            onTextChange = { _message = it },
            onTextSizeDecrease = { if (size > 15.sp) size -= sizeDiff },
            onTextSizeIncrease = { if (size < 45.sp) size += sizeDiff },
            onBoldToggle = { isBold = it },
            onAlignmentChange = { alignment = it }
        ) { height ->
            Text(
                _message,
                modifier
                    .padding(bottom = height)
                    .padding(30.dp)
                    .align(Alignment.Center)
                    .fillMaxWidth(),
                color,
                fontSize = size,
                fontWeight = weight,
                textAlign = alignment
            )
        }
    }
}