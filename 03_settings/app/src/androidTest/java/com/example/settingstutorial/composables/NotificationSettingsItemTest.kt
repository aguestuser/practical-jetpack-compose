package com.example.settingstutorial.composables

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.settingstutorial.composables.Tags.TAG_TOGGLE_ITEM
import org.junit.Rule
import org.junit.Test

class NotificationSettingsItemTest {
    @get:Rule val composeTestRule = createComposeRule()
    private val title = "Enable Notifications"

    @Test
    fun title_displayed() {
        composeTestRule.setContent { NotificationSettingsItem(title = title, checked = true) {} }
        composeTestRule.onNodeWithText(title).assertIsDisplayed()
    }

    @Test
    fun setting_checked() {
        composeTestRule.setContent { NotificationSettingsItem(title = title, checked = true) {} }
        composeTestRule.onNodeWithTag(TAG_TOGGLE_ITEM).assertIsOn()
    }
}
