package com.example.authtutorial.composables

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.authtutorial.AuthenticationMode

class AuthModeProvider : PreviewParameterProvider<AuthenticationMode> {
    override val values: Sequence<AuthenticationMode> =
        sequenceOf(
            AuthenticationMode.SIGN_UP,
            AuthenticationMode.SIGN_IN,
        )
}