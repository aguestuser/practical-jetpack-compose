package com.example.authtutorial.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.example.authtutorial.AuthenticationMode
import com.example.authtutorial.ui.theme.AuthTutorialTheme

@Composable
fun AuthenticationForm(
    modifier: Modifier = Modifier,
    authenticationMode: AuthenticationMode,
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        AuthenticationTitle(authenticationMode = authenticationMode)
    }
}

@Preview(showBackground = true)
@Composable
fun AuthenticationFormThePreview(
    @PreviewParameter(AuthModeProvider::class) authenticationMode: AuthenticationMode
) {
    AuthTutorialTheme { AuthenticationForm(authenticationMode = authenticationMode) }
}
