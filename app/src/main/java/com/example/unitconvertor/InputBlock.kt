package com.example.unitconvertor

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InputBlock(
    conversion: Conversion,
    inputText: MutableState<String>,
    context:Context = LocalContext.current,
    calculate:(String) ->Unit
) {
    Column(modifier = Modifier.padding(0.dp, 20.dp, 0.dp, 0.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(value = inputText.value,
                onValueChange = {inputText.value = it},
                modifier = Modifier.fillMaxWidth(0.65F),
                keyboardOptions =  KeyboardOptions(capitalization = KeyboardCapitalization.None,
                    autoCorrect = true,
                    keyboardType = KeyboardType.Number)
            )
            Text(text = conversion.convertFrom,
                fontSize = 24.sp,
                modifier = Modifier.fillMaxWidth(0.35F))
        }
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(onClick = {
            if(inputText.value != ""){
                calculate(inputText.value)
            } else {
                Toast.makeText(context, "Please enter your value", Toast.LENGTH_LONG).show()
            }
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "convert",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue)
        }

    }
}