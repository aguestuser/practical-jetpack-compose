package com.example.settingstutorial.composables

import androidx.annotation.StringRes
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import com.example.settingstutorial.R
import com.example.settingstutorial.composables.Tags.TAG_CHECK_ITEM
import com.example.settingstutorial.composables.Tags.TAG_MARKETING_OPTION
import com.example.settingstutorial.composables.Tags.TAG_TOGGLE_ITEM
import org.junit.Rule
import org.junit.Test

class SettingsTest {
    @get:Rule val composeTestRule = createComposeRule()

    @Test
    fun all_Settings_Are_Displayed() {
        composeTestRule.setContent { Settings() }
        assertSettingIsDisplayed(R.string.setting_enable_notifications)
        assertSettingIsDisplayed(R.string.setting_show_hints)
        assertSettingIsDisplayed(R.string.setting_manage_subscription)
        assertSettingIsDisplayed(R.string.setting_app_version_title)
        assertSettingIsDisplayed(R.string.setting_option_theme)
        assertSettingIsDisplayed(R.string.setting_option_marketing)
    }

    @Test
    fun enable_Notifications_Toggles_Selected_State() {
        composeTestRule.setContent { Settings() }
        composeTestRule
            .onNodeWithText(
                InstrumentationRegistry.getInstrumentation()
                    .targetContext
                    .getString(R.string.setting_enable_notifications)
            )
            .performClick()
        composeTestRule.onNodeWithTag(TAG_TOGGLE_ITEM).assertIsOn()
    }

    @Test
    fun show_Hints_Toggles_Selected_State() {
        composeTestRule.setContent { Settings() }
        composeTestRule
            .onNodeWithText(
                InstrumentationRegistry.getInstrumentation()
                    .targetContext
                    .getString(R.string.setting_show_hints)
            )
            .performClick()
        composeTestRule.onNodeWithTag(TAG_CHECK_ITEM).assertIsOn()
    }

    @Test
    fun marketing_Options_Toggles_Selected_State() {
        composeTestRule.setContent { Settings() }
        composeTestRule
            .onNodeWithText(
                InstrumentationRegistry.getInstrumentation()
                    .targetContext
                    .resources
                    .getStringArray(R.array.setting_options_marketing_choice)[1]
            )
            .performClick()
        composeTestRule.onNodeWithTag(TAG_MARKETING_OPTION + 1).assertIsSelected()
    }



    private fun assertSettingIsDisplayed(@StringRes title: Int) {
        composeTestRule
            .onNodeWithText(
                InstrumentationRegistry.getInstrumentation().targetContext.getString(title)
            )
            .assertIsDisplayed()
    }
}
