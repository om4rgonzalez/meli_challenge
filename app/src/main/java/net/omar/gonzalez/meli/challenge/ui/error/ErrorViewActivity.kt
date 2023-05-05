package net.omar.gonzalez.meli.challenge.ui.error

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.viewpager2.widget.ViewPager2
import net.omar.gonzalez.meli.challenge.databinding.ActivityGenericErrorBinding
import net.omar.gonzalez.meli.challenge.databinding.ActivityProductDetailBinding
import net.omar.gonzalez.meli.challenge.ui.MainSearchActivity
import net.omar.gonzalez.meli.challenge.ui.base.BaseViewActivity
import net.omar.gonzalez.meli.challenge.ui.model.getViewType
import net.omar.gonzalez.meli.challenge.ui.productdetail.ProductDetailActivity

class ErrorViewActivity: BaseViewActivity() {

    companion object {
        const val MESSAGE =
            "net.omar.gonzalez.meli.challenge.ui.error.message"

        fun getIntent(
            context: Context,
            message: String? = null
        ): Intent {
            val intent = Intent(context, ErrorViewActivity :: class.java).apply {
                putExtra(MESSAGE, message)
            }
            return intent
        }
    }

    lateinit var binding: ActivityGenericErrorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGenericErrorBinding.inflate(
            layoutInflater,
            baseBinding.baseContainer,
            true
        )

        setupView()
    }

    private fun setupView() {
        intent.getStringExtra(MESSAGE)?.let { description ->
            binding.errorDescription.text = description
        }

        binding.understoodButtom.setOnClickListener {
            startActivity(
                MainSearchActivity.getIntent(this)
            )
            finish()
        }

    }

}