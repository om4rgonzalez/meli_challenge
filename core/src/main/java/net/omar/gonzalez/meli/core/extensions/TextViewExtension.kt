package net.omar.gonzalez.meli.core.extensions

import android.graphics.Paint
import android.widget.TextView

fun TextView.stroke() {
    setPaintFlags(this.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
}