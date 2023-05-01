package net.omar.gonzalez.meli.challenge.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import net.omar.gonzalez.meli.challenge.R
import net.omar.gonzalez.meli.challenge.databinding.SearchCustomViewBinding
import net.omar.gonzalez.meli.challenge.ui.model.SearchCustomModel

class SearchBoxCustomView(
    context: Context,
    attrs: AttributeSet?): ConstraintLayout(context, attrs) {

    var onTextChange: ((String) -> Unit)? = null

    var onEditTextClickListener: (() -> Unit)? = null

    private val binding: SearchCustomViewBinding by lazy {
        SearchCustomViewBinding.inflate(
            LayoutInflater.from(context),
            this,
            true
        )
    }

    fun setupView(viewType: SearchCustomModel) {
        with(viewType) {
            binding.container.setBackgroundColor(resources.getColor(backGroundColor))
            binding.backButton.isVisible = showBackButton
            binding.deleteButton.isVisible = showDeleteButton
            if (showSearchButton)
                binding.input.setCompoundDrawables(
                    context.getDrawable(R.drawable.ic_search),
                    null,
                    null,
                    null
                )
            else
                binding.input.setCompoundDrawables(
                    null,
                    null,
                    null,
                    null
                )
        }

        binding.input.setOnFocusChangeListener { view, b ->
            onEditTextClickListener?.invoke()
        }

        binding.input.doOnTextChanged { text, _, _, _ ->
            onTextChange?.invoke(text.toString())
        }
    }

    fun onEditTextClickListener(onEditTextClickListener: (() -> Unit)? = null) {
        this.onEditTextClickListener = onEditTextClickListener
    }

    fun setOnTextChangeListener(onTextChange: ((String) -> Unit)? = null) {
        this.onTextChange = onTextChange
    }

    fun setText(text: String) {
        binding.input.setText(text)
    }
}