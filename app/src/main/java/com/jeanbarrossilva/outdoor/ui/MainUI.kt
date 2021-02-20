package com.jeanbarrossilva.outdoor.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jeanbarrossilva.outdoor.ui.defaults.OutdoorTheme

@Composable
fun MainUI(modifier: Modifier = Modifier) {
    OutdoorTheme.Fill {
        MessageUI(modifier)
    }
}