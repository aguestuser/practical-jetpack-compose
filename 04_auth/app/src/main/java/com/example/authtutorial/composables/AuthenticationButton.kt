package com.example.authtutorial.composables

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.example.authtutorial.AuthenticationMode
import com.example.authtutorial.R
import com.example.authtutorial.ui.theme.AuthTutorialTheme

@Composable
fun AuthenticationButton(
    modifier: Modifier = Modifier,
    authenticationMode: AuthenticationMode,
    canAuthenticate: Boolean,
    onAuthenticate: () -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = onAuthenticate,
        enabled = canAuthenticate,
    ) {
        Text(
            text =
                stringResource(
                    id =
                        when (authenticationMode) {
                            AuthenticationMode.SIGN_UP -> R.string.action_sign_up
                            AuthenticationMode.SIGN_IN -> R.string.action_sign_in
                        }
                )
        )
    }
}

@Preview(widthDp = 300, showBackground = true)
@Composable
fun AuthenticationButtonPreview(
    @PreviewParameter(AuthButtonStateProvider::class) authButtonState: AuthButtonStateProvider.AuthButtonState,
) {
    AuthTutorialTheme {
        AuthenticationButton(
            authenticationMode = authButtonState.authenticationMode,
            canAuthenticate = authButtonState.isAuthEnabled,
            onAuthenticate = {},
        )
    }
}
