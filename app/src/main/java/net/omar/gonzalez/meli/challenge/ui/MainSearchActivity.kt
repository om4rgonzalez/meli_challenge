package net.omar.gonzalez.meli.challenge.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.omar.gonzalez.meli.challenge.databinding.ActivityMainSearchBinding
import net.omar.gonzalez.meli.challenge.ui.base.BaseViewActivity
import net.omar.gonzalez.meli.challenge.ui.model.SearchCustomModel
import net.omar.gonzalez.meli.challenge.ui.model.getViewType
import net.omar.gonzalez.meli.challenge.ui.search.SearchActivity

class MainSearchActivity : BaseViewActivity() {

    companion object {
        fun getIntent(context: Context): Intent = Intent(context, MainSearchActivity::class.java)
    }

    private val binding: ActivityMainSearchBinding by lazy {
        ActivityMainSearchBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.searchView.setupView(getViewType(true))
        setContentView(binding.root)
        setupView()
    }

    private fun setupView() {
        binding.searchView.onEditTextClickListener {
            startActivity(
                SearchActivity.getIntent(
                    this,
                    getViewType(false)
                )
            )
        }
    }
}