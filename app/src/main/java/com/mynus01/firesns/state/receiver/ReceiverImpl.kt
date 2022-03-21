package com.mynus01.firesns.state.receiver

import com.mynus01.firesns.state.action.OutputAction
import com.mynus01.firesns.state.store.Store
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class ReceiverImpl @Inject constructor(private val store: Store) : Receiver {
    override suspend fun observe(action: suspend (value: OutputAction) -> Unit) {
        store.outputState.collect(action)
    }
}