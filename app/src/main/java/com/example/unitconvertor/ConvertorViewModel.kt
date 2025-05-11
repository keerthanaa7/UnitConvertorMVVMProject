package com.example.unitconvertor

import androidx.lifecycle.ViewModel

class ConvertorViewModel : ViewModel() {

    fun getConversions() = listOf<Conversion>(
        Conversion(1, "Pounds to kilograms", "lbs", "kg", 0.453592),
        Conversion(2, "Kilograms to Pounds", "kg", "lbs", 2.20462),
        Conversion(3, "Yards to Meters", "yd", "m", 0.9144),
        Conversion(4, "Meters to yards", "m", "yd", 1.09361)
    )
}