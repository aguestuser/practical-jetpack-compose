package com.example.settingstutorial.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.settingstutorial.ui.theme.SettingsTutorialTheme

@Composable
fun SectionSpacer(modifier: Modifier = Modifier) {
    Box(
        modifier =
            modifier
                .height(48.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colors.onSurface.copy(alpha = 0.12f))
    )
}

@Preview
@Composable
fun SectionSpacerPreview() {
    SettingsTutorialTheme { SectionSpacer() }
}
