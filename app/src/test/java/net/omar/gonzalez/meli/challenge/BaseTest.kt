package net.omar.gonzalez.meli.challenge

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule

abstract class BaseTest {

    @ExperimentalCoroutinesApi
    private val testCoroutineDispatcher = TestCoroutineDispatcher()

    @ExperimentalCoroutinesApi
    private val testCoroutineScope = TestCoroutineScope(testCoroutineDispatcher)

    /**
     * A JUnit Test Rule that swaps the background executor used by the Architecture
     * Components with a different one which executes each task synchronously.
     * To handle the postValue in liveData which is async
     */
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @ObsoleteCoroutinesApi
    @ExperimentalCoroutinesApi
    @Before
    fun setupBase() {
        Dispatchers.setMain(testCoroutineDispatcher)
    }

    @ObsoleteCoroutinesApi
    @ExperimentalCoroutinesApi
    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testCoroutineDispatcher.cleanupTestCoroutines()
        testCoroutineScope.cleanupTestCoroutines()
    }

    fun falseAssertion() {
        Assert.assertEquals(0, 1)
    }

}