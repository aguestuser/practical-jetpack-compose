package com.example.settingstutorial.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.settingstutorial.R
import com.example.settingstutorial.SettingsViewModel
import com.example.settingstutorial.ui.theme.SettingsTutorialTheme

// BOOKMARK: pg 113

@Composable
fun Settings() {
    val viewModel: SettingsViewModel = viewModel()
    val state = viewModel.uiState.collectAsState().value
    SettingsTutorialTheme {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.surface,
                contentPadding = PaddingValues(start = 12.dp)
            ) {
                Icon(
                    tint = MaterialTheme.colors.onSurface,
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(id = R.string.cd_go_back),
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = stringResource(id = R.string.title_settings),
                    color = MaterialTheme.colors.onSurface
                )
            }
            Divider()
            NotificationSettingsItem(
                modifier = Modifier.fillMaxWidth(),
                title = stringResource(id = R.string.setting_enable_notifications),
                checked = state.notificationsEnabled,
                onCheckChanged = viewModel::toggleNotificationsSetting,
            )
            Divider()
            HintSetttingsItem(
                modifier = Modifier.fillMaxWidth(),
                title = stringResource(id = R.string.setting_show_hints),
                checked = state.hintsEnabled,
                onShowHintsToggled = viewModel::toggleHintsSetting,
            )
            Divider()
            ManageSubscriptionSettingsItem(
                title = stringResource(id = R.string.setting_manage_subscription),
                onSettingClicked = { print("Navigate to Subscriptions Screen!") }
            )
            SectionSpacer()
            MarketingOptionsSettingItem(
                selectedOption = state.marketingOption,
                onOptionSelected = viewModel::setMarketingSetting,
            )
            Divider()
            ThemeSettingItem(
                modifier = Modifier.fillMaxWidth(),
                selectedTheme = state.themeOption,
                viewModel::setTheme
            )
            SectionSpacer()
            AppVersionSettingsItem(
                modifier = Modifier.fillMaxWidth(),
                appVersion = stringResource(id = R.string.setting_option_theme)
            )
            Divider()
        }
    }
}

@Composable
fun SettingsItem(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Surface(modifier = modifier.heightIn(min = 56.dp)) { content() }
}

///////////// PREVIEWS //////////////////

@Preview
@Composable
fun SettingsTheRealPreview() {
    SettingsTutorialTheme { Settings() }
}
