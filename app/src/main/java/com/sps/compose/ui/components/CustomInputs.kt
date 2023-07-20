package com.sps.compose.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SPSEditText(
    modifier: Modifier = Modifier,
    textState: MutableState<TextFieldValue>,
    maxLength: Int,
    required: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    label: String = "",
    placeHolder: String = "",
    error: String? = null,
    onValueChange: (TextFieldValue)-> Unit = {}
) {
    Column(modifier = modifier.padding(bottom = 16.dp)) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = placeHolder) },
            label = { Text(text = label) },
            value = textState.value,
//            colors = TextFieldDefaults.textFieldColors(
//                backgroundColor = colors.onSurface,
//                cursorColor = Color.Black,
//                disabledLabelColor = colors.onSurface,
//                focusedIndicatorColor = Color.Transparent,
//                unfocusedIndicatorColor = Color.Transparent
//            ),
            onValueChange = {
                if (it.text.length <= maxLength) {
                    textState.value = it
                    onValueChange(it)
                }
            },
//            shape = RoundedCornerShape(8.dp),
            singleLine = true,
            trailingIcon = {
                if (textState.value.text.isNotEmpty()) {
                    IconButton(onClick = { textState.value = TextFieldValue("") }) {
                        Icon(
                            imageVector = Icons.Outlined.Close,
                            contentDescription = null
                        )
                    }
                }
            },
            keyboardOptions = keyboardOptions,
            isError = (error != null)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (required) {
                Text(
                    text = "Required",
                    style = MaterialTheme.typography.labelMedium
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "${textState.value.text.length} / $maxLength",
                modifier = Modifier,
                style = MaterialTheme.typography.labelMedium
            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDown(suggestions: List<String>, value: MutableState<String>) {
    var expanded by remember { mutableStateOf(false) }
    var textfieldSize by remember { mutableStateOf(Size.Zero) }
    val icon = if (expanded)
        Icons.Default.ArrowUpward
    else
        Icons.Default.ArrowDownward

    Column(Modifier.padding(bottom = 8.dp)) {
        OutlinedTextField(
            readOnly = true,
            shape = RoundedCornerShape(8.dp),
            singleLine = true,
            value = value.value,
            onValueChange = { value.value = it },
            colors = TextFieldDefaults.textFieldColors(
//                backgroundColor = colors.onSurface,
//                cursorColor = Color.Black,
//                disabledLabelColor = colors.onSurface,
//                focusedIndicatorColor = Color.Transparent,
//                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    //This value is used to assign to the DropDown the same width
                    textfieldSize = coordinates.size.toSize()
                },
            trailingIcon = {
                Icon(
                    imageVector = icon, "contentDescription",
                    Modifier.clickable {
                        expanded = !expanded
                    })
            }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textfieldSize.width.toDp() })
        ) {
            suggestions.forEach { label ->
                DropdownMenuItem(onClick = {
                    value.value = label
                    expanded = false
                }, text = { Text(text = label) })
            }
        }
    }
}