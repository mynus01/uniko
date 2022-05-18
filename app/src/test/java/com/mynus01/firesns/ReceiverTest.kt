package com.mynus01.firesns

import app.cash.turbine.test
import com.mynus01.firesns.presentation.state.action.InAction
import com.mynus01.firesns.presentation.state.action.OutAction
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

class ReceiverTest: BaseEnvironment() {
    @Test
    fun input_action_should_become_output_action(
        inputAction: InAction,
        expectedResult: OutAction
    ) = runTest {
        receiver.observe(OutAction.InitOutput::class)?.test {
            dispatcher.dispatch(inputAction)
            Assert.assertEquals(expectedResult, awaitItem())
            cancelAndIgnoreRemainingEvents()
        }
    }
}