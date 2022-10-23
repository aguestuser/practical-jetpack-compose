package com.example.settingstutorial

import com.example.settingstutorial.ui.theme.Theme

data class SettingsState(
    val notificationsEnabled: Boolean = false,
    val hintsEnabled: Boolean = false,
    val marketingOption: MarketingOption = MarketingOption.ALLOWED,
    val themeOption: Theme = Theme.SYSTEM,
)

enum class MarketingOption(val id: Int) {
    ALLOWED(0),
    NOT_ALLOWED(1);

    companion object {
        fun fromInt(value: Int): MarketingOption =
            when (value) {
                0 -> ALLOWED
                1 -> NOT_ALLOWED
                else ->
                    throw IllegalArgumentException("$value is not a valid marketing option value")
            }
    }
}
