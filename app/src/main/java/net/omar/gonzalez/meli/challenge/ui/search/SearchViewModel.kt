package net.omar.gonzalez.meli.challenge.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.omar.gonzalez.meli.challenge.data.model.History
import net.omar.gonzalez.meli.challenge.repository.HistoryRepository

class SearchViewModel(
    val repository: HistoryRepository
): ViewModel() {

    var historyList: List<History> = listOf()

    fun getHistory() = liveData {
        historyList = repository.getAll()
        emit(historyList)
    }

    fun insertHistory(key: String) {
        if (historyList.none { history ->
                history.searchKey.uppercase().trim() == key.uppercase().trim()
        }
        )
            viewModelScope.launch {
                repository.insert(History(key))
            }
    }


}