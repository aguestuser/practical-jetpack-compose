package com.example.authtutorial.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.authtutorial.PasswordRequirement
import com.example.authtutorial.ui.theme.AuthTutorialTheme

@Composable
fun PasswordRequirements(
    modifier: Modifier = Modifier,
    satisfiedRequirements: List<PasswordRequirement>,
) {
    Column(modifier = modifier) {
        PasswordRequirement.values().forEach {
            Requirement(
                reqirementLabel = stringResource(id = it.label),
                isSatisfied = satisfiedRequirements.contains(it),
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PasswordRequirementsPreview() {
    AuthTutorialTheme {
        PasswordRequirements(satisfiedRequirements = listOf(PasswordRequirement.NUMBER))
    }
}
