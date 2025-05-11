package com.example.unitconvertor

data class Conversion(
    val id: Int,
    val description:String,
    val convertFrom:String,
    val convertTo:String,
    val multiply:Double
)
