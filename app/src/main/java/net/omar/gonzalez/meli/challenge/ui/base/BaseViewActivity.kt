package net.omar.gonzalez.meli.challenge.ui.base

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import net.omar.gonzalez.meli.challenge.R
import net.omar.gonzalez.meli.challenge.databinding.ActivityBaseViewBinding
import net.omar.gonzalez.meli.challenge.ui.error.ErrorViewActivity

abstract class BaseViewActivity : AppCompatActivity() {
    protected lateinit var baseBinding: ActivityBaseViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        baseBinding = ActivityBaseViewBinding.inflate(layoutInflater)
        setContentView(baseBinding.root)
    }

    open fun showProgressBar(show: Boolean) {
    }

    open fun showError(context: Context, message: String?) {
        startActivity(ErrorViewActivity.getIntent(context, message))
    }

}