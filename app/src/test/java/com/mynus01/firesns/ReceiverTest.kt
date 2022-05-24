package com.mynus01.firesns

import app.cash.turbine.test
import com.mynus01.firesns.presentation.uniko.action.InAction
import com.mynus01.firesns.presentation.uniko.action.OutAction
import com.mynus01.uniko.action.InputAction
import com.mynus01.uniko.action.OutputAction
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

@ExperimentalCoroutinesApi
class ReceiverTest : BaseEnvironment() {
    @Test
    fun input_action_should_become_output_action() = runTest {
        val inputAction = InAction.InitInput
        val outputAction = OutAction.InitOutput

        receiver.observe(OutAction.InitOutput::class)?.test {
            dispatcher.dispatch(inputAction)
            Assert.assertEquals(outputAction, awaitItem())
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun unhandled_action_should_throw_illegal_argument_exception() = runTest {
        val inputAction = TestExceptionInput()

        receiver.observe(TestExceptionOutput::class)?.test {
            dispatcher.dispatch(inputAction)
            Assert.assertThrows(IllegalStateException::class.java) {
                this@runTest.runTest {
                    awaitItem()
                    cancelAndIgnoreRemainingEvents()
                }
            }
        }
    }

    inner class TestExceptionInput : InputAction
    inner class TestExceptionOutput : OutputAction
}