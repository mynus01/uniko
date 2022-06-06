package com.mynus01.uniko

import com.mynus01.uniko.action.InputAction
import com.mynus01.uniko.action.OutputAction
import com.mynus01.uniko.dispatcher.BaseDispatcher
import com.mynus01.uniko.dispatcher.Dispatcher
import com.mynus01.uniko.mock.store.MockStore
import com.mynus01.uniko.receiver.BaseReceiver
import com.mynus01.uniko.receiver.Receiver
import com.mynus01.uniko.store.Store
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Before

@ExperimentalCoroutinesApi
open class BaseEnvironment {
    private lateinit var testDispatcher: TestDispatcher
    lateinit var store: Store<InputAction, OutputAction>
    lateinit var dispatcher: Dispatcher<InputAction>
    lateinit var receiver: Receiver

    @Before
    fun create_environment() {
        testDispatcher = UnconfinedTestDispatcher()
        store = MockStore(testDispatcher)
        dispatcher = BaseDispatcher(store, testDispatcher)
        receiver = BaseReceiver(store, testDispatcher)
    }
}