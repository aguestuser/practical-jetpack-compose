package com.example.settingstutorial.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.settingstutorial.R
import com.example.settingstutorial.composables.Tags.TAG_CHECK_ITEM
import com.example.settingstutorial.ui.theme.SettingsTutorialTheme

@Composable
fun HintSetttingsItem(
    modifier: Modifier = Modifier,
    title: String,
    checked: Boolean,
    onShowHintsToggled: (isChecked: Boolean) -> Unit
) {
    val isEnabledDescription =
        if (checked) stringResource(id = R.string.cd_hints_enabled)
        else stringResource(id = R.string.hints_disabled)
    SettingsItem(modifier = modifier) {
        Row(
            modifier =
                Modifier
                    .testTag(TAG_CHECK_ITEM)
                    .toggleable(
                        value = checked,
                        onValueChange = onShowHintsToggled,
                        role = Role.Checkbox
                    )
                    .semantics { stateDescription = isEnabledDescription }
                    .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = title, modifier = Modifier.weight(1f))
            Checkbox(checked = checked, onCheckedChange = null)
        }
    }
}

@Preview(widthDp = 400)
@Composable
fun HintSettingsItemPreview() {
    var isChecked by remember { mutableStateOf(true) }
    SettingsTutorialTheme {
        HintSetttingsItem(title = "Enable Hints", checked = isChecked) { isChecked = it }
    }
}
