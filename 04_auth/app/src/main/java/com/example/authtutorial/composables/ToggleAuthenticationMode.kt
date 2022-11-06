package com.example.authtutorial.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.authtutorial.AuthenticationMode
import com.example.authtutorial.R
import com.example.authtutorial.ui.theme.AuthTutorialTheme

@Composable
fun AuthenticationModeToggle(
    modifier: Modifier = Modifier,
    authenticationMode: AuthenticationMode,
    onToggleAuthMode: () -> Unit
) {
    Surface(
        modifier = modifier.padding(top = 16.dp),
        elevation = 8.dp,
    ) {
        TextButton(
            modifier = Modifier.background(MaterialTheme.colors.surface).padding(8.dp),
            onClick = onToggleAuthMode,
        ) {
            Text(
                stringResource(
                    when (authenticationMode) {
                        AuthenticationMode.SIGN_IN -> R.string.action_need_account
                        AuthenticationMode.SIGN_UP -> R.string.action_already_have_account
                    }
                )
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 300)
@Composable
fun ToggleAuthenticationModePreview(
    @PreviewParameter(AuthModeProvider::class) authenticationMode: AuthenticationMode
) {
    AuthTutorialTheme {
        AuthenticationModeToggle(
            authenticationMode = authenticationMode,
            onToggleAuthMode = {}
        )
    }
}
