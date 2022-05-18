package com.mynus01.firesns

import com.mynus01.firesns.presentation.state.MyStore
import com.mynus01.firesns.presentation.state.action.InAction
import com.mynus01.firesns.presentation.state.action.OutAction
import com.mynus01.firesns.state.dispatcher.Dispatcher
import com.mynus01.firesns.state.dispatcher.DispatcherImpl
import com.mynus01.firesns.state.receiver.Receiver
import com.mynus01.firesns.state.receiver.ReceiverImpl
import com.mynus01.firesns.state.store.Store
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Before

@ExperimentalCoroutinesApi
open class BaseEnvironment {
    private val testDispatcher = UnconfinedTestDispatcher()
    lateinit var store: Store<InAction, OutAction>
    lateinit var receiver: Receiver
    lateinit var dispatcher: Dispatcher<InAction>

    @Before
    fun before() {
        store = MyStore(testDispatcher)
        dispatcher = DispatcherImpl(testDispatcher, store)
        receiver = ReceiverImpl(testDispatcher, store)
    }
}