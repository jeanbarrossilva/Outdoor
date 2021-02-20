package com.jeanbarrossilva.outdoor.extension

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.SaverScope
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

object SaverX {
    val TextUnitMutableStateSaver: Saver<MutableState<TextUnit>, Float> = mutableStateSaverOf(saving = { it.value }, restoration = { it.sp })

    private fun <O, S : Any> mutableStateSaverOf(saving: (O) -> S, restoration: (S) -> O) =
        object : Saver<MutableState<O>, S> {
            override fun restore(value: S) = mutableStateOf(restoration(value))

            override fun SaverScope.save(value: MutableState<O>) = saving(value.value)
        }
}