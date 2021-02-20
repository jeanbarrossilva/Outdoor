package com.jeanbarrossilva.outdoor.extension

import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

object TextUnitX {
    operator fun TextUnit.minus(other: TextUnit) = (this.value - other.value).sp

    operator fun TextUnit.plus(other: TextUnit) = (this.value + other.value).sp
}