package com.example.authtutorial.composables

import androidx.compose.animation.AnimatedVisibility
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
import com.example.authtutorial.PasswordRequirement
import com.example.authtutorial.ui.theme.AuthTutorialTheme

@Composable
fun AuthenticationForm(
    modifier: Modifier = Modifier,
    authenticationMode: AuthenticationMode,
    canAuthenticate: Boolean,
    email: String?,
    password: String?,
    satisfiedPasswordRequirements: List<PasswordRequirement>,
    onAuthenticate: () -> Unit,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onToggleAuthMode: () -> Unit,
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
                Spacer(modifier = Modifier.height(16.dp))
                PasswordInput(
                    modifier = Modifier.fillMaxWidth().focusRequester(passwordFocusRequester),
                    password = password,
                    onPasswordChanged = onPasswordChanged,
                    onDoneClicked = onAuthenticate,
                )

                Spacer(modifier = Modifier.height(12.dp))
                AnimatedVisibility(visible = authenticationMode == AuthenticationMode.SIGN_UP) {
                    PasswordRequirements(satisfiedRequirements = satisfiedPasswordRequirements)
                }
                Spacer(modifier = Modifier.height(12.dp))

                AuthenticationButton(
                    authenticationMode = authenticationMode,
                    canAuthenticate = canAuthenticate,
                    onAuthenticate = onAuthenticate,
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        AuthenticationModeToggle(
            modifier = Modifier.fillMaxWidth(),
            authenticationMode = authenticationMode,
            onToggleAuthMode = onToggleAuthMode,
        )
    }
}

@Preview(showBackground = true, widthDp = 400)
@Composable
fun AuthenticationFormThePreview(
    @PreviewParameter(AuthModeProvider::class) authenticationMode: AuthenticationMode
) {
    var email by remember { mutableStateOf("foo@bar.com") }
    var password by remember { mutableStateOf("p4ssw0rd!") }
    AuthTutorialTheme {
        AuthenticationForm(
            authenticationMode = authenticationMode,
            canAuthenticate = authenticationMode == AuthenticationMode.SIGN_IN,
            email = email,
            password = password,
            onAuthenticate = {},
            satisfiedPasswordRequirements = listOf(PasswordRequirement.CAPITAL_LETTER),
            onEmailChanged = { email = it },
            onPasswordChanged = { password = it },
            onToggleAuthMode = {}
        )
    }
}
