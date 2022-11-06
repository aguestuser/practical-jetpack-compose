package com.example.authtutorial.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.text
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.authtutorial.R

@Composable
fun Requirement(
    modifier: Modifier = Modifier,
    reqirementLabel: String,
    isSatisfied: Boolean,
) {
    val statusMessage =
        if (isSatisfied) stringResource(id = R.string.password_requirement_satisfied, reqirementLabel)
        else stringResource(id = R.string.password_requirement_needed, reqirementLabel)
    val tint =
        if (isSatisfied) MaterialTheme.colors.primary
        else MaterialTheme.colors.onSurface.copy(alpha = 0.4f)
    Row(
        modifier =
            modifier.padding(6.dp).semantics(mergeDescendants = false) {
                text = AnnotatedString(statusMessage)
            },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            modifier = Modifier.size(12.dp),
            imageVector = Icons.Default.Check,
            contentDescription = null,
            tint = tint
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            modifier = Modifier.clearAndSetSemantics {},
            fontSize = 12.sp,
            color = tint,
            text = statusMessage,
        )
    }
}

@Preview(showBackground = true, widthDp = 400)
@Composable
fun RequirementPreview(@PreviewParameter(BooleanProvider::class) isSatisfied: Boolean) {
    MaterialTheme { Requirement(reqirementLabel = "requirement", isSatisfied = isSatisfied) }
}
