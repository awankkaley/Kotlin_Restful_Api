package com.awankkaley.springapi.util

import java.text.SimpleDateFormat
import java.util.*

fun Date.dateToString(): String {
    val format = "dd-MM-y hh:mm:ss Z"
    val dateFormatter = SimpleDateFormat(format, Locale.getDefault())
    return dateFormatter.format(this)
}