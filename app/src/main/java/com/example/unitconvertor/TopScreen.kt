package com.example.unitconvertor

import android.icu.text.DecimalFormat
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import java.math.RoundingMode

@Composable
fun TopScreen(conversionlist: List<Conversion>) {
    val selectedConversion:MutableState<Conversion?> = remember { mutableStateOf(null) }
    val inputText:MutableState<String> = remember { mutableStateOf("") }
    val typedvalue = remember { mutableStateOf("0.0") }
    ConversionMenu(conversionlist) {
        selectedConversion.value = it
    }
    selectedConversion.value?.let {
        InputBlock(conversion = it, inputText = inputText) {
            input->
            Log.i("Top screen ", "user typed $input")
        }
    }
    if(typedvalue.value != "0.0"){
        val input = typedvalue.value.toDouble()
        val multiply = selectedConversion.value!!.multiply
        val result = input * multiply

        val df = DecimalFormat("#.####")
        val roundedResult =
    }
}