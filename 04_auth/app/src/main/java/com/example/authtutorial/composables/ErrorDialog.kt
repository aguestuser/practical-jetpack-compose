package com.example.authtutorial.composables

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.authtutorial.R
import com.example.authtutorial.ui.theme.AuthTutorialTheme

@Composable
fun ErrorDialog(
    modifier: Modifier = Modifier,
    error: String,
    onDismissError: () -> Unit,
) {
    AlertDialog(
        modifier = modifier,
        title = { Text(text = stringResource(id = R.string.error_title)) },
        text = { Text(text = error) },
        confirmButton = {
            TextButton(onClick = onDismissError) {
                Text(text = stringResource(id = R.string.error_action))
            }
        },
        onDismissRequest = onDismissError,
    )
}

@Preview
@Composable
fun ErrorDialogPreview() {
    AuthTutorialTheme { ErrorDialog(error = "BOOM!", onDismissError = {}) }
}
