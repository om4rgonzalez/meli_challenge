package net.omar.gonzalez.meli.challenge

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import net.omar.gonzalez.meli.challenge.data.api.model.Resource
import net.omar.gonzalez.meli.challenge.repository.SearchRepository
import net.omar.gonzalez.meli.challenge.ui.productlist.ProductListViewModel
import net.omar.gonzalez.meli.challenge.utils.SearchMockCreator.Companion.createSearchFailureResponseMock
import net.omar.gonzalez.meli.challenge.utils.SearchMockCreator.Companion.createSearchResponseMock
import net.omar.gonzalez.meli.core.extensions.getOrAwaitValue
import org.junit.Before

import org.junit.Test
import org.mockito.Mockito

@ExperimentalCoroutinesApi
class ProductListViewModelTest : BaseTest() {

    private lateinit var viewModel: ProductListViewModel
    private lateinit var repository: SearchRepository

    @Before
    fun setupTest() {
        repository = Mockito.mock(SearchRepository::class.java)

        viewModel = ProductListViewModel(repository)
    }

    @Test
    fun searchProducts_SuccessTest() = runTest {
        val searchProductResponse = createSearchResponseMock()
        Mockito.`when`(
            repository.search("")
        ).thenReturn(Resource.Success(searchProductResponse))

        when (val apiResponse = viewModel.searchProducts("").getOrAwaitValue()) {
            is Resource.Success -> {
                assertTrue(apiResponse.values.site_id == "1")
            }
            is Resource.Failure -> {
                falseAssertion()
            }
        }
    }

    @Test
    fun searchProducts_FailureTest() = runTest {
        val searchProductResponse = createSearchFailureResponseMock()
        Mockito.`when`(
            repository.search("")
        ).thenReturn(searchProductResponse)

        when (val apiResponse = viewModel.searchProducts("").getOrAwaitValue()) {
            is Resource.Success -> {
                falseAssertion()
            }
            is Resource.Failure -> {
                assertTrue(apiResponse.isNEtworkError)
            }
        }
    }

}