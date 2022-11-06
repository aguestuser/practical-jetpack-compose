package com.example.authtutorial.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.authtutorial.AuthenticationEvent
import com.example.authtutorial.AuthenticationState
import com.example.authtutorial.AuthenticationViewModel
import com.example.authtutorial.ui.theme.AuthTutorialTheme

@Composable
fun Authentication() {
    val viewModel: AuthenticationViewModel = viewModel()

    AuthTutorialTheme {
        AuthenticationContent(
            modifier = Modifier.fillMaxWidth(),
            state = viewModel.uiState.collectAsState().value,
            handleEvent = viewModel::handleEvent,
        )
    }
}

@Composable
fun AuthenticationContent(
    modifier: Modifier,
    state: AuthenticationState,
    handleEvent: (event: AuthenticationEvent) -> Unit,
) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        if (state.isLoading) {
            CircularProgressIndicator()
        } else {
            AuthenticationForm(
                authenticationMode = state.authenticationMode,
                email = state.email,
                password = state.password,
                satisfiedPasswordRequirements = state.satisfiedPasswordRequirements,
                onAuthenticate = { handleEvent(AuthenticationEvent.AuthenticationRequested)},
                onEmailChanged = { handleEvent(AuthenticationEvent.EmailChanged(it)) },
                onPasswordChanged = { handleEvent(AuthenticationEvent.PasswordChanged(it))},
            )
        }
    }
}

@Preview(widthDp = 400, showBackground = true)
@Composable
fun AuthenticationPreview() {
    AuthTutorialTheme { Authentication() }
}
