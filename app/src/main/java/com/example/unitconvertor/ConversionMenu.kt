package com.example.unitconvertor

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize

@Composable
fun ConversionMenu(list:List<Conversion>, modifier: Modifier = Modifier,
                   convert:(Conversion) -> Unit) {

    var displayText by remember { mutableStateOf("Select the conversion value") }
    var textfieldSize by remember { mutableStateOf(Size.Zero) }
    var expanded by remember { mutableStateOf(false) }
    val icon = if (expanded) {
        Icons.Filled.KeyboardArrowUp
    } else {
        Icons.Filled.KeyboardArrowDown
    }

    // Drop down menu is paired with a edit text. The displaytext is filled with the drop down menu
    // item choosen by the user and that fills the edit text when recomposition happens
    OutlinedTextField(
        value = displayText,
        onValueChange = { displayText = it },
        textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
        modifier = modifier.fillMaxWidth().onGloballyPositioned { layoutCoordinates ->
            textfieldSize = layoutCoordinates.size.toSize()
        },
        label = { Text(text = "Conversion Type") },
        trailingIcon = {
            Icon(icon, contentDescription = "icon", modifier.clickable { expanded = !expanded })

        },
        readOnly = true
    )
    DropdownMenu(expanded = expanded,
        onDismissRequest = { expanded = false },
        modifier = Modifier.width(with(LocalDensity.current) { textfieldSize.width.toDp() })
    ) {
        list.forEach { conversion ->
            DropdownMenuItem(text = { Text(conversion.description) },
                onClick = {displayText = conversion.description
                expanded = false
                convert(conversion)})

        }

    }
}

