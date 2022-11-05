package com.example.authtutorial.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.authtutorial.AuthenticationMode
import com.example.authtutorial.ui.theme.AuthTutorialTheme

@Composable
fun AuthenticationForm(
    modifier: Modifier = Modifier,
    authenticationMode: AuthenticationMode,
    email: String?,
    onEmailChanged: (String) -> Unit,
    password: String?,
    onPasswordChanged: (String) -> Unit,
    onAuthenticate: () -> Unit,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        AuthenticationTitle(authenticationMode = authenticationMode)
        Spacer(modifier = Modifier.height(40.dp))
        Card(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
            elevation = 4.dp,
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val passwordFocusRequester = FocusRequester()
                EmailInput(
                    modifier = Modifier.fillMaxWidth(),
                    email = email,
                    onEmailChanged = onEmailChanged,
                    onNextClicked = { passwordFocusRequester.requestFocus() }
                )
                PasswordInput(
                    modifier = Modifier.fillMaxWidth().focusRequester(passwordFocusRequester),
                    password = password,
                    onPasswordChanged = onPasswordChanged,
                    onDoneClicked = onAuthenticate,
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 400, heightDp = 300)
@Composable
fun AuthenticationFormThePreview(
    @PreviewParameter(AuthModeProvider::class) authenticationMode: AuthenticationMode
) {
    var email by remember { mutableStateOf("foo@bar.com") }
    var password by remember { mutableStateOf("p4ssw0rd!") }
    AuthTutorialTheme {
        AuthenticationForm(
            authenticationMode = authenticationMode,
            email = email,
            onEmailChanged = { email = it },
            password = password,
            onPasswordChanged = { password = it },
            onAuthenticate = {},
        )
    }
}
