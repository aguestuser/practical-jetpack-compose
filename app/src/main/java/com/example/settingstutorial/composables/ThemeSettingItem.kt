package com.example.settingstutorial.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.settingstutorial.R
import com.example.settingstutorial.ui.theme.SettingsTutorialTheme
import com.example.settingstutorial.ui.theme.Theme

@Composable
fun ThemeSettingItem(
    modifier: Modifier = Modifier,
    selectedTheme: Theme,
    onOptionSelected: (Theme) -> Unit,
) {
    var isExpanded by remember { mutableStateOf(false) }
    SettingsItem(modifier = modifier) {
        Row(
            modifier =
                Modifier.clickable(
                        onClickLabel = stringResource(id = R.string.cd_select_theme),
                        onClick = { isExpanded = !isExpanded }
                    )
                    .padding(16.dp)
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(id = R.string.setting_option_theme)
            )
            Text(text = stringResource(id = selectedTheme.label))
        }
        DropdownMenu(
            expanded = isExpanded,
            offset = DpOffset(16.dp, 0.dp),
            onDismissRequest = { isExpanded = false }
        ) {
            Theme.values().forEach { theme ->
                DropdownMenuItem(
                    onClick = {
                        onOptionSelected(theme)
                        isExpanded = false
                    }
                ) {
                    Text(text = stringResource(id = theme.label))
                }
            }
        }
    }
}

@Preview(widthDp = 400)
@Composable
fun ThemeSettingItemThePreview() {
    var selectedTheme by remember { mutableStateOf(Theme.LIGHT) }
    SettingsTutorialTheme { ThemeSettingItem(selectedTheme = selectedTheme) { selectedTheme = it } }
}
