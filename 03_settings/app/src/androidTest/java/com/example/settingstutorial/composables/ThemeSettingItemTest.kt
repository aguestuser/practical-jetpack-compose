package com.example.settingstutorial.composables

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import com.example.settingstutorial.composables.Tags.TAG_SELECT_THEME
import com.example.settingstutorial.composables.Tags.TAG_THEME_OPTION
import com.example.settingstutorial.ui.theme.Theme
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class ThemeSettingItemTest {
    @get:Rule val composeTestRule = createComposeRule()

    @Test
    fun theme_Options_Displayed() {
        composeTestRule.setContent {
            ThemeSettingItem(selectedTheme = Theme.DARK, onOptionSelected = {})
        }
        composeTestRule.onNodeWithTag(TAG_SELECT_THEME).performClick()
        Theme.values().forEach { theme ->
            composeTestRule
                .onNodeWithTag(
                    TAG_THEME_OPTION +
                        InstrumentationRegistry.getInstrumentation()
                            .targetContext
                            .getString(theme.label)
                )
                .assertIsDisplayed()
        }
    }
}
