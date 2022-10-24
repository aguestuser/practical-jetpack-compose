package com.example.settingstutorial.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.settingstutorial.R
import com.example.settingstutorial.ui.theme.SettingsTutorialTheme

@Composable
fun AppVersionSettingsItem(
    modifier: Modifier = Modifier,
    appVersion: String,
) {
    val title = stringResource(id = R.string.setting_app_version_title)
    SettingsItem(modifier = modifier) {
        Row(
            modifier = Modifier.padding(16.dp).semantics(mergeDescendants = true){},
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(modifier = Modifier.weight(1f), text = title)
            Text(text = appVersion)
        }
    }
}

@Preview(device = Devices.NEXUS_5X)
@Composable
fun AppVersionSettingsItemPreview() {
    SettingsTutorialTheme { AppVersionSettingsItem(appVersion = "1.3.12") }
}
