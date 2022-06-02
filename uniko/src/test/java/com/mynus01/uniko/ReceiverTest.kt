package com.mynus01.uniko

import app.cash.turbine.test
import com.mynus01.uniko.mock.action.input.*
import com.mynus01.uniko.mock.action.output.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

@ExperimentalCoroutinesApi
class ReceiverTest : BaseEnvironment() {
    @Test
    fun input_action_should_become_output_action() = runTest {
        val inputAction = TestInput
        val outputAction = TestOutput

        receiver.observe(TestOutput::class)?.test {
            dispatcher.dispatch(inputAction)
            Assert.assertEquals(outputAction, awaitItem())
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun unhandled_action_should_throw_illegal_argument_exception() = runTest {
        val inputAction = TestExceptionInput

        receiver.observe(TestExceptionOutput::class)?.test {
            dispatcher.dispatch(inputAction)
            Assert.assertThrows(IllegalStateException::class.java) {
                runTest {
                    awaitItem()
                    cancelAndIgnoreRemainingEvents()
                }
            }
        }
    }
}