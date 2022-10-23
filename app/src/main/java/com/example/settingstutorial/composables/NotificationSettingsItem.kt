package com.example.settingstutorial.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.settingstutorial.R
import com.example.settingstutorial.ui.theme.SettingsTutorialTheme

@Composable
fun NotificationSettingsItem(
    modifier: Modifier = Modifier,
    title: String,
    checked: Boolean,
    onCheckChanged: (Boolean) -> Unit
) {
    val notificationStateDescription =
        if (checked) stringResource(id = R.string.cd_notifications_enabled)
        else stringResource(id = R.string.cd_notifications_disabled)

    SettingsItem(modifier = modifier) {
        Row(
            modifier =
            modifier
                .toggleable(
                    value = checked,
                    onValueChange = onCheckChanged,
                    role = Role.Switch,
                )
                .semantics { stateDescription = notificationStateDescription }
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = title, modifier = modifier.weight(1f))
            Switch(checked = checked, onCheckedChange = null)
        }
    }
}

@Preview(widthDp = 400)
@Composable
fun NotificationSettingsPreview() {
    var isChecked by remember { mutableStateOf(true) }
    SettingsTutorialTheme {
        NotificationSettingsItem(title = "Enable notifications", checked = isChecked) { isChecked = it }
    }
}