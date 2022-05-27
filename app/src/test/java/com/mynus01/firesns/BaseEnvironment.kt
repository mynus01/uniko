package com.mynus01.firesns

import com.mynus01.firesns.presentation.uniko.store.AppStore
import com.mynus01.uniko.action.InputAction
import com.mynus01.uniko.action.OutputAction
import com.mynus01.uniko.dispatcher.BaseDispatcher
import com.mynus01.uniko.dispatcher.Dispatcher
import com.mynus01.uniko.receiver.BaseReceiver
import com.mynus01.uniko.receiver.Receiver
import com.mynus01.uniko.store.Store
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Before

@ExperimentalCoroutinesApi
open class BaseEnvironment {
    private val testDispatcher = UnconfinedTestDispatcher()
    lateinit var store: Store<InputAction, OutputAction>
    lateinit var receiver: Receiver
    lateinit var dispatcher: Dispatcher<InputAction>

    @Before
    fun create_environment() {
        store = AppStore(testDispatcher)
        dispatcher = BaseDispatcher(store, testDispatcher)
        receiver = BaseReceiver(store, testDispatcher)
    }
}