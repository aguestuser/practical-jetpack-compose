package com.example.settingstutorial

import androidx.lifecycle.ViewModel
import com.example.settingstutorial.ui.theme.Theme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class SettingsViewModel : ViewModel() {
  val uiState = MutableStateFlow(SettingsState())

  fun toggleNotificationsSetting(newSetting: Boolean) {
    uiState.value = uiState.value.copy(notificationsEnabled = newSetting)
    uiState.update { it.copy(notificationsEnabled = newSetting) }
  }

  fun toggleHintsSetting(newSetting: Boolean) {
    uiState.value = uiState.value.copy(hintsEnabled = newSetting)
  }

  fun setMarketingSetting(option: MarketingOption) {
    uiState.value = uiState.value.copy(marketingOption = option)
  }

  fun setTheme(theme: Theme) {
    uiState.value = uiState.value.copy(themeOption = theme)
  }
}
