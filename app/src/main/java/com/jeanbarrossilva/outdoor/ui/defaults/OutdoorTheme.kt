package com.jeanbarrossilva.outdoor.ui.defaults

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.jeanbarrossilva.outdoor.R

object OutdoorTheme {
    object Colors {
        @Composable
        private fun primary() = colorResource(R.color.primary)

        @Composable
        private fun primaryVariant() = colorResource(R.color.primaryVariant)

        @Composable
        private fun secondary() = colorResource(R.color.secondary)

        object Palette {
            @Composable
            private fun light() = lightColors(primary(), primaryVariant(), secondary())

            @Composable
            private fun dark() = darkColors(primary(), primaryVariant(), secondary())

            @Composable
            fun dynamic() = if (isSystemInDarkTheme()) dark() else light()
        }
    }

    @Composable
    private fun Get(content: @Composable () -> Unit) {
        MaterialTheme(
            Colors.Palette.dynamic(),
            content = content
        )
    }

    @Composable
    fun Wrap(content: @Composable () -> Unit) {
        Get(content)
    }

    @Composable
    fun Fill(modifier: Modifier = Modifier, content: @Composable BoxScope.() -> Unit) {
        Get {
            Box(
                modifier
                    .fillMaxSize(),
                content = content
            )
        }
    }
}