package com.mynus01.firesns

import app.cash.turbine.test
import com.mynus01.firesns.presentation.uniko.action.InAction
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

@ExperimentalCoroutinesApi
class DispatcherTest : BaseEnvironment() {
    @Test
    fun dispatcher_should_send_action_to_store() = runTest {
        val input = InAction.InitInput

        store.inputState.test {
            dispatcher.dispatch(input)
            Assert.assertEquals(awaitItem(), input)
            cancelAndIgnoreRemainingEvents()
        }
    }
}