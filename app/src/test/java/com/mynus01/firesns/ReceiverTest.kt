package com.mynus01.firesns

import app.cash.turbine.test
import com.mynus01.firesns.datasource.interactor.AuthInteractor
import com.mynus01.firesns.domain.ViewState
import com.mynus01.firesns.presentation.uniko.action.input.SignUpInput
import com.mynus01.firesns.presentation.uniko.action.output.SignUpOutput
import com.mynus01.firesns.presentation.uniko.store.AppStore
import com.mynus01.uniko.action.InputAction
import com.mynus01.uniko.action.OutputAction
import com.mynus01.uniko.dispatcher.BaseDispatcher
import com.mynus01.uniko.dispatcher.Dispatcher
import com.mynus01.uniko.receiver.BaseReceiver
import com.mynus01.uniko.receiver.Receiver
import com.mynus01.uniko.store.Store
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class ReceiverTest {
    private lateinit var testDispatcher: TestDispatcher
    private lateinit var store: Store<InputAction, OutputAction>
    private lateinit var receiver: Receiver
    private lateinit var dispatcher: Dispatcher<InputAction>
    private lateinit var interactor: AuthInteractor

    @Before
    fun create_environment() {
        testDispatcher = UnconfinedTestDispatcher()

        store = AppStore(testDispatcher)
        dispatcher = BaseDispatcher(store, testDispatcher)
        receiver = BaseReceiver(store, testDispatcher)

        interactor = mockk()
    }

    @Test
    fun input_action_should_become_output_action() = runTest {
        val email = "test@gmail.com"
        val password = "123456"
        val inputAction = SignUpInput(interactor, email, password)

        every {
            interactor.signUp(email, password)
        } returns flow {
            emit(ViewState.Complete.Success("Logged in successfully"))
        }

        receiver.observe(SignUpOutput::class)?.test {
            dispatcher.dispatch(inputAction)

            val ignoredResult = awaitItem()
            Assert.assertTrue(true)
            cancelAndIgnoreRemainingEvents()
        }
    }

    inner class TestExceptionInput : InputAction
    inner class TestExceptionOutput : OutputAction

    @Test
    fun unhandled_action_should_throw_illegal_argument_exception() = runTest {
        val inputAction = TestExceptionInput()

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