package com.sps.compose.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SearchTextField(
    modifier: Modifier = Modifier,
    value: String,
    readOnly: Boolean = false,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    placeholderText: String = "Placeholder",
    fontSize: TextUnit = 16.sp,
    onTextChange: (String) -> Unit,
    onSearch: () -> Unit = {},
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors()
) {
    BasicTextField(modifier = modifier
//        .background(
//            MaterialTheme.colorScheme.onSurface.copy(alpha = 0.15f),
//            MaterialTheme.shapes.extraLarge,
//        )
        .border(
            width = 1.dp,
            shape = MaterialTheme.shapes.small,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.15f)
        )
        .fillMaxWidth(),
        value = value,
        onValueChange = {
            onTextChange(it)
        },
//        colors = colors,
        readOnly = readOnly,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(
            onSearch = {
                onSearch()
            }),
        singleLine = true,
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
//        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.4f),
//        fontSize = fontSize,
        textStyle = LocalTextStyle.current.copy(
            color = MaterialTheme.colorScheme.primary,
            fontSize = fontSize
        ),
        decorationBox = { innerTextField ->
            Row(
                modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (leadingIcon != null) leadingIcon()
                Box(
                    Modifier
                        .weight(1f)
                        .padding(start = 10.dp, top = 4.dp), contentAlignment = Alignment.CenterStart) {
                    if (value.isEmpty()) Text(
                        placeholderText,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                        fontSize = fontSize,
                    )
                    innerTextField()
                }
                if (trailingIcon != null) trailingIcon()
            }
        }
    )
}