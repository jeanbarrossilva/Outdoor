package com.jeanbarrossilva.outdoor.ui

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jeanbarrossilva.outdoor.extension.SaverX.TextUnitMutableStateSaver
import com.jeanbarrossilva.outdoor.extension.TextUnitX.minus
import com.jeanbarrossilva.outdoor.extension.TextUnitX.plus
import com.jeanbarrossilva.outdoor.ui.component.TextEditorToolbar
import com.jeanbarrossilva.outdoor.ui.defaults.OutdoorTheme

@Composable
@Preview
fun MessageUI(
    modifier: Modifier = Modifier,
    message: String = "Tap the text icon below and type something!"
) {
    var dynamicMessage by rememberSaveable { mutableStateOf(message) }
    var size by rememberSaveable(saver = TextUnitMutableStateSaver) { mutableStateOf(14.sp) }
    var isBold by rememberSaveable { mutableStateOf(false) }
    var alignment by rememberSaveable { mutableStateOf(TextAlign.Center) }

    val sizeDiff = 2.5.sp
    val weight = if (isBold) FontWeight.Bold else FontWeight.Normal

    OutdoorTheme.Fill {
        TextEditorToolbar(
            Modifier
                .align(Alignment.BottomCenter),
            text = message,
            onTextChange = { dynamicMessage = it },
            onTextSizeDecrease = { size -= sizeDiff },
            onTextSizeIncrease = { size += sizeDiff },
            onBoldToggle = { isBold = it },
            onAlignmentChange = { alignment = it }
        ) { height ->
            Text(
                dynamicMessage,
                Modifier
                    .padding(bottom = height)
                    .padding(30.dp)
                    .align(Alignment.Center)
                    .fillMaxWidth(),
                fontSize = size,
                fontWeight = weight,
                textAlign = alignment
            )
        }
    }
}