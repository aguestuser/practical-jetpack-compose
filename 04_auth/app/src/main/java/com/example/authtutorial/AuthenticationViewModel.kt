package com.example.authtutorial

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AuthenticationViewModel : ViewModel() {
    val uiState = MutableStateFlow(AuthenticationState())

    fun handleEvent(event: AuthenticationEvent) {
        when (event) {
            is AuthenticationEvent.AuthenticationRequested -> authenticate()
            is AuthenticationEvent.EmailChanged -> updateEmail(event.email)
            is AuthenticationEvent.ErrorDismissed -> dismissError()
            is AuthenticationEvent.PasswordChanged -> updatePassword(event.password)
            is AuthenticationEvent.ToggleAuthenticationMode -> toggleAuthenticationMode()
        }
    }

    private fun authenticate() {
        if (!uiState.value.isFormValid()) return
        uiState.update { it.copy(isLoading = true) }
        // make some network call
        viewModelScope.launch(Dispatchers.IO) {
            delay(2000L)
            withContext(Dispatchers.Main) {
                uiState.update {
                    it.copy(
                        isLoading = false,
                        error = "There was a horrible error!!!"
                    )
                }
            }
        }
    }

    private fun dismissError(){
        uiState.update {
            it.copy(error = null)
        }
    }

    private fun toggleAuthenticationMode() {
        val prevAuthenticationMode = uiState.value.authenticationMode
        uiState.update {
            it.copy(
                authenticationMode =
                    when (prevAuthenticationMode) {
                        AuthenticationMode.SIGN_IN -> AuthenticationMode.SIGN_UP
                        AuthenticationMode.SIGN_UP -> AuthenticationMode.SIGN_IN
                    }
            )
        }
    }

    private fun updateEmail(email: String) = uiState.update { it.copy(email = email) }

    private fun updatePassword(password: String) {
        val requirements = mutableListOf<PasswordRequirement>()

        if (password.length > 7) requirements.add(PasswordRequirement.EIGHT_CHARACTERS)
        if (password.any { it.isUpperCase() }) requirements.add(PasswordRequirement.CAPITAL_LETTER)
        if (password.any() { it.isDigit() }) requirements.add(PasswordRequirement.NUMBER)

        uiState.update {
            it.copy(
                password = password,
                satisfiedPasswordRequirements = requirements,
            )
        }
    }
}

sealed class AuthenticationEvent {
    object AuthenticationRequested : AuthenticationEvent()
    class EmailChanged(val email: String) : AuthenticationEvent()
    object ErrorDismissed : AuthenticationEvent()
    class PasswordChanged(val password: String) : AuthenticationEvent()
    object ToggleAuthenticationMode : AuthenticationEvent()
}
