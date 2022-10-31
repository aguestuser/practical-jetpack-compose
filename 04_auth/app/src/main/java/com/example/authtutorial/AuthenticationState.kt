package com.example.authtutorial

import androidx.annotation.StringRes

data class AuthenticationState(
    val authenticationMode: AuthenticationMode = AuthenticationMode.SIGN_IN,
    val email: String? = null,
    val password: String? = null,
    val passwordRequirements: List<PasswordRequirement> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
) {
    fun isFormValid(): Boolean =
        password?.isNotEmpty() == true &&
            email?.isNotEmpty() == true &&
            (authenticationMode == AuthenticationMode.SIGN_IN) ||
            passwordRequirements.containsAll(PasswordRequirement.values().toList())
}

enum class PasswordRequirement(@StringRes val label: Int) {
    CAPITAL_LETTER(R.string.password_requirement_capital),
    NUMBER(R.string.password_requirement_digit),
    EIGHT_CHARACTERS(R.string.password_requirement_characters),
}

enum class AuthenticationMode {
    SIGN_UP,
    SIGN_IN
}
