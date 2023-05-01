package net.omar.gonzalez.meli.challenge.ui.productlist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import net.omar.gonzalez.meli.challenge.data.api.model.Resource
import net.omar.gonzalez.meli.challenge.databinding.ActivityProductListBinding
import net.omar.gonzalez.meli.challenge.repository.HistoryRepository
import net.omar.gonzalez.meli.challenge.repository.SearchRepository
import net.omar.gonzalez.meli.challenge.ui.base.BaseViewActivity
import net.omar.gonzalez.meli.challenge.ui.search.HistoryAdapter
import net.omar.gonzalez.meli.challenge.ui.search.SearchViewModel
import net.omar.gonzalez.meli.challenge.utils.getViewModel

class ProductListActivity: BaseViewActivity() {
    companion object {
        const val SEARCH_KEY =
            "net.omar.gonzalez.meli.challenge.ui.productlist.searchKey"

        fun getIntent(
            context: Context,
            searchKey: String
        ): Intent {
            val intent = Intent(context, ProductListActivity :: class.java).apply {
                putExtra(SEARCH_KEY, searchKey)
            }
            return intent
        }
    }

    lateinit var binding: ActivityProductListBinding

    private val viewModel: ProductListViewModel by lazy {
        getViewModel {
            ProductListViewModel(
                SearchRepository()
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListBinding.inflate(
            layoutInflater,
            baseBinding.baseContainer,
            true
        )
        setupView()
        setupObservable()
    }

    private fun setupView() {

    }

    private fun setupObservable() {
        intent.getStringExtra(SEARCH_KEY)?.let {key ->
            showProgress(true)
            viewModel.searchProducts(key).observe(this) {response ->
                when(response) {
                    is Resource.Success -> {
                        showProgress(false)
                        binding.productList.layoutManager = LinearLayoutManager(this)
                        binding.productList.adapter = ProductListAdapter(
                            this,
                            response.values.results
                        )
                    }
                    else -> {

                    }
                }
            }
        }

    }

    private fun showProgress(show: Boolean) {
        binding.loading.isVisible = show
    }

}