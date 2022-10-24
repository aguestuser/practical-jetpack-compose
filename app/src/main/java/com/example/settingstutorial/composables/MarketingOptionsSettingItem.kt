package com.example.settingstutorial.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.settingstutorial.MarketingOption
import com.example.settingstutorial.R
import com.example.settingstutorial.composables.Tags.TAG_MARKETING_OPTION
import com.example.settingstutorial.ui.theme.SettingsTutorialTheme

@Composable
fun MarketingOptionsSettingItem(
    modifier: Modifier = Modifier,
    selectedOption: MarketingOption,
    onOptionSelected: (MarketingOption) -> Unit
) {
    val title = stringResource(id = R.string.setting_option_marketing)
    val options = stringArrayResource(id = R.array.setting_options_marketing_choice)
    SettingsItem(modifier = modifier) {
        Column(
            modifier = modifier.padding(16.dp),
        ) {
            Text(text = title)
            Spacer(modifier = Modifier.height(8.dp))
            options.forEachIndexed { idx, option ->
                Row(
                    modifier =
                        Modifier.fillMaxWidth()
                            .testTag(TAG_MARKETING_OPTION + idx)
                            .selectable(
                                selected = selectedOption.id == idx,
                                role = Role.RadioButton,
                                onClick = { onOptionSelected(MarketingOption.fromInt(idx)) }
                            )
                            .padding(10.dp)
                    ,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    RadioButton(
                        selected = selectedOption.id == idx,
                        onClick = null,
                    )
                    Text(modifier = Modifier.padding(start = 18.dp), text = option)
                }
            }
        }
    }
}

@Preview(widthDp = 400)
@Composable
fun PreviewTheMarketingOptionsSettingItem() {
    var selectedOption by remember { mutableStateOf(MarketingOption.NOT_ALLOWED) }
    SettingsTutorialTheme {
        MarketingOptionsSettingItem(
            selectedOption = selectedOption,
            onOptionSelected = { selectedOption = it }
        )
    }
}
