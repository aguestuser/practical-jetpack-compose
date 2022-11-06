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

class AuthButtonStateProvider : PreviewParameterProvider<AuthButtonStateProvider.AuthButtonState> {
    data class AuthButtonState(
        val authenticationMode: AuthenticationMode,
        val isAuthEnabled: Boolean,
    )
    override val values: Sequence<AuthButtonState> =
        sequenceOf(
            AuthButtonState(AuthenticationMode.SIGN_UP, true),
            AuthButtonState(AuthenticationMode.SIGN_UP, false),
            AuthButtonState(AuthenticationMode.SIGN_IN, true),
            AuthButtonState(AuthenticationMode.SIGN_IN, false),
        )
}

class BooleanProvider : PreviewParameterProvider<Boolean> {
    override val values: Sequence<Boolean> = sequenceOf(true, false)
}
