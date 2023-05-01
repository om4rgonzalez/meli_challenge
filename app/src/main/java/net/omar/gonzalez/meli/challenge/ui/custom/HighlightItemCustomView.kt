package net.omar.gonzalez.meli.challenge.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import net.omar.gonzalez.meli.challenge.databinding.ItemHighlightedBinding

class HighlightItemCustomView(
    context: Context,
    attrs: AttributeSet?
): ConstraintLayout(context, attrs) {

    private val binding: ItemHighlightedBinding by lazy {
        ItemHighlightedBinding.inflate(
            LayoutInflater.from(context),
            this
        )
    }

    fun setText(text: String) {
        binding.itemText.text = text
    }

}