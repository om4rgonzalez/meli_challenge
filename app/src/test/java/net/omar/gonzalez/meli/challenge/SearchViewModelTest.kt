package net.omar.gonzalez.meli.challenge

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import net.omar.gonzalez.meli.challenge.repository.HistoryRepository
import net.omar.gonzalez.meli.challenge.ui.search.SearchViewModel
import net.omar.gonzalez.meli.challenge.utils.HistoryMockCreator.Companion.createHistoryWithItemsResponse
import net.omar.gonzalez.meli.core.extensions.getOrAwaitValue
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

@ExperimentalCoroutinesApi
class SearchViewModelTest : BaseTest() {

    private lateinit var viewModel: SearchViewModel
    private lateinit var repository: HistoryRepository

    @Before
    fun setupTest() {
        repository = mock(HistoryRepository::class.java)

        viewModel = SearchViewModel(repository)
    }

    @Test
    fun getHistoryWithItems_Test() = runBlockingTest {

        val historyResponse = createHistoryWithItemsResponse()
        Mockito.`when`(
            repository.getAll()
        ).thenReturn(historyResponse)

        viewModel.getHistory().getOrAwaitValue()

        Assert.assertFalse(viewModel.historyList.isEmpty())
    }
}