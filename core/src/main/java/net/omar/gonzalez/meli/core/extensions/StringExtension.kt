package net.omar.gonzalez.meli.core.extensions

import java.text.NumberFormat
import java.util.Locale

fun String.toMoneyFormat(): String {
    val value = this.toDoubleOrNull() ?: return this // if the string is not a valid number, return the original string
    val formatter = NumberFormat.getCurrencyInstance(Locale.getDefault())
    return formatter.format(value)
}