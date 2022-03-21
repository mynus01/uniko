package com.mynus01.firesns.state.dispatcher

import com.mynus01.firesns.state.action.InputAction
import com.mynus01.firesns.state.action.OutputAction
import com.mynus01.firesns.state.store.Store
import javax.inject.Inject

class DispatcherImpl @Inject constructor(private val store: Store) : Dispatcher {
    override fun dispatch(action: InputAction) {
        store.inputState.value = action
    }
    override fun dispatch(action: OutputAction) {
        store.outputState.value = action
    }
}