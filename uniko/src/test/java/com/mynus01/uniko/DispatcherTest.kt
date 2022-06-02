package com.mynus01.uniko

import app.cash.turbine.test
import com.mynus01.uniko.mock.action.input.TestInput
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

@ExperimentalCoroutinesApi
class DispatcherTest : BaseEnvironment() {
    @Test
    fun dispatcher_should_send_action_to_store() = runTest {
        val input = TestInput

        store.inputState.test {
            dispatcher.dispatch(input)
            Assert.assertEquals(awaitItem(), input)
            cancelAndIgnoreRemainingEvents()
        }
    }
}