package net.omar.gonzalez.meli.challenge.ui.search

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import net.omar.gonzalez.meli.challenge.databinding.ActivitySearchBinding
import net.omar.gonzalez.meli.challenge.repository.HistoryRepository
import net.omar.gonzalez.meli.challenge.ui.base.BaseViewActivity
import net.omar.gonzalez.meli.challenge.ui.model.SearchCustomModel
import net.omar.gonzalez.meli.challenge.utils.getViewModel

class SearchActivity : BaseViewActivity() {

    companion object {
        const val MODEL_VIEW =
            "net.omar.gonzalez.meli.challenge.ui.search.modelView"

        fun getIntent(
            context: Context,
            model: SearchCustomModel
        ): Intent {
            val intent = Intent(context, SearchActivity :: class.java).apply {
                putExtra(MODEL_VIEW, model)
            }
            return intent
        }
    }

    private lateinit var binding: ActivitySearchBinding
    private val viewModel: SearchViewModel by lazy {
        getViewModel {
            SearchViewModel(
                HistoryRepository(this@SearchActivity)
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(
            layoutInflater,
            baseBinding.baseContainer,
            true
        )
        setupObserver()
        setupView()

    }

    private fun setupView() {
        intent.getParcelableExtra<SearchCustomModel>(MODEL_VIEW)?.let { model ->
            binding.searchView.setupView(model)
        }

        binding.searchView.setOnTextChangeListener() { text ->
            (binding.searchHistory.adapter as HistoryAdapter)?.let {adapter ->
                adapter.refreshView(adapter.historyList.filter { list -> list.searchKey.contains(text) })
            }
        }




//        viewModel.insertHistory("celular")
//        viewModel.insertHistory("motorola")
//        viewModel.insertHistory("mini compresor")

    }

    private fun setupObserver() {
        viewModel.getHistory().observe(this) { history ->
            binding.searchHistory.layoutManager = LinearLayoutManager(this)
            binding.searchHistory.adapter = HistoryAdapter(history)

            (binding.searchHistory.adapter as HistoryAdapter).let { adapter ->
                adapter.setOnItemClickListener {history ->
                    search(history.searchKey)
                }

                adapter.setupOnUpperButtonClickListener {history ->
                    binding.searchView.setText(history.searchKey)
                }
            }
        }
    }

    private fun search(key: String) {
        Log.d("SEARCH", "ITEM TO SEARCH: "+key)
        viewModel.insertHistory(key)
    }
}