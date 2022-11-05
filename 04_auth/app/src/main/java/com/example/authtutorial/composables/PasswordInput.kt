package com.example.authtutorial.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.authtutorial.R
import com.example.authtutorial.ui.theme.AuthTutorialTheme

@Composable
fun PasswordInput(
    modifier: Modifier = Modifier,
    password: String?,
    onPasswordChanged: (String) -> Unit,
    onDoneClicked: () -> Unit,
) {
    var isPasswordHidden by remember { mutableStateOf(true) }
    TextField(
        modifier = modifier,
        value = password ?: "",
        onValueChange = onPasswordChanged,
        label = { Text(text = stringResource(R.string.label_password)) },
        singleLine = true,
        visualTransformation =
            if (isPasswordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = null) },
        trailingIcon = {
            Icon(
                modifier =
                    Modifier.clickable(
                        onClickLabel =
                            stringResource(
                                if (isPasswordHidden) R.string.cd_show_password
                                else R.string.cd_hide_password
                            )
                    ) {
                        isPasswordHidden = !isPasswordHidden
                    },
                imageVector =
                    if (isPasswordHidden) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                contentDescription = null,
            )
        },
        keyboardOptions =
            KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password,
            ),
        keyboardActions =
            KeyboardActions(
                onDone = { onDoneClicked() },
            ),
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewPasswordInput() {
    var password by remember { mutableStateOf("myp455w0rd") }
    AuthTutorialTheme {
        PasswordInput(
            password = password,
            onPasswordChanged = { password = it },
            onDoneClicked = {},
        )
    }
}
