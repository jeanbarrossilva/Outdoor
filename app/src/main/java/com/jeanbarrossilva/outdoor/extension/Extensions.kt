package com.jeanbarrossilva.outdoor.extension

import android.text.TextUtils
import android.view.View
import java.util.*

object Extensions {
    fun isLtr() = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == View.LAYOUT_DIRECTION_LTR
}