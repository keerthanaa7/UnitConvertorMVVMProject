package com.example.unitconvertor

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun BaseScreen(convertorViewModel: ConvertorViewModel){
    val conversionlist = convertorViewModel.getConversions()
    Column (modifier = Modifier.padding(30.dp)){
        TopScreen(conversionlist)
        Spacer(modifier = Modifier.height(20.dp))
        HistoryScreen()
    }
}