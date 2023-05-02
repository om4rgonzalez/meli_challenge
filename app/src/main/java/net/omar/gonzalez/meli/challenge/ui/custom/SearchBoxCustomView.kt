package net.omar.gonzalez.meli.challenge.ui.custom

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.inputmethod.EditorInfo
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import net.omar.gonzalez.meli.challenge.R
import net.omar.gonzalez.meli.challenge.databinding.SearchCustomViewBinding
import net.omar.gonzalez.meli.challenge.ui.model.SearchCustomModel

class SearchBoxCustomView(
    context: Context,
    attrs: AttributeSet?): ConstraintLayout(context, attrs) {

    private var onTextChange: ((String) -> Unit)? = null

    private var onEditTextClickListener: (() -> Unit)? = null

    private var onSearchClick: ((String) -> Unit)? = null

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

        binding.input.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                event.keyCode == KeyEvent.KEYCODE_ENTER) {
                onSearchClick?.invoke(binding.input.text.toString())
            }
            true
        }
    }

    fun onEditTextClickListener(onEditTextClickListener: (() -> Unit)? = null) {
        this.onEditTextClickListener = onEditTextClickListener
    }

    fun setOnTextChangeListener(onTextChange: ((String) -> Unit)? = null) {
        this.onTextChange = onTextChange
    }

    fun setOnSearchButtonClickListener(onSearchClick: ((String) -> Unit)? = null) {
        this.onSearchClick = onSearchClick
    }

    fun setText(text: String) {
        binding.input.setText(text)
    }

    fun inputRequestFocus() = binding.input.requestFocus()
}