package com.example.authtutorial.composables

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.authtutorial.R
import com.example.authtutorial.ui.theme.AuthTutorialTheme

@Composable
fun EmailInput(
    modifier: Modifier = Modifier,
    email: String?,
    onEmailChanged: (String) -> Unit,
    onNextClicked: () -> Unit,
) {
    TextField(
        modifier = modifier,
        value = email ?: "",
        onValueChange = onEmailChanged,
        label = { Text(text = stringResource(R.string.label_email)) },
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = null,
            )
        },
        keyboardOptions =
            KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next,
            ),
        keyboardActions =
            KeyboardActions(
                onNext = { onNextClicked() },
            )
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewEmailInput() {
    var email by remember { mutableStateOf("foo@bar.com") }
    AuthTutorialTheme {
        EmailInput(
            email = email,
            onEmailChanged = { email = it },
            onNextClicked = {},
        )
    }
}
