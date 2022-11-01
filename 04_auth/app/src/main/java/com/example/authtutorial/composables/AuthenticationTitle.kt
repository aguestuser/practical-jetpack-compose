package com.example.authtutorial.composables

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import com.example.authtutorial.AuthenticationMode
import com.example.authtutorial.R
import com.example.authtutorial.ui.theme.AuthTutorialTheme

@Composable
fun AuthenticationTitle(
    modifier: Modifier = Modifier,
    authenticationMode: AuthenticationMode,
) {
    Text(
        text =
            stringResource(
                when (authenticationMode) {
                    AuthenticationMode.SIGN_IN -> R.string.label_sign_in_to_account
                    AuthenticationMode.SIGN_UP -> R.string.label_sign_up_for_account
                }
            ),
        fontSize = 24.sp,
        fontWeight = FontWeight.Black
    )
}

@Preview(showBackground = true)
@Composable
fun AuthenticationTitlePreview(
    @PreviewParameter(AuthModeProvider::class) authenticationMode: AuthenticationMode
) {
    AuthTutorialTheme { AuthenticationTitle(authenticationMode = authenticationMode) }
}
