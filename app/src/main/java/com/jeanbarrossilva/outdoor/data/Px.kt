package com.jeanbarrossilva.outdoor.data

import android.util.TypedValue
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

data class Px(val value: Float) {
    @Composable
    fun toDp() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, value, LocalContext.current.resources?.displayMetrics).dp

    companion object {
        val Number.px get() = Px(this.toFloat())
    }
}