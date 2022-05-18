package com.mynus01.firesns.state.dispatcher

import com.mynus01.firesns.di.DispatcherMain
import com.mynus01.firesns.state.action.InputAction
import com.mynus01.firesns.state.action.OutputAction
import com.mynus01.firesns.state.store.Store
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class DispatcherImpl<I: InputAction, O: OutputAction> @Inject constructor(
    @DispatcherMain
    private val coroutineDispatcher: CoroutineDispatcher,
    private val store: Store<I, O>
) : Dispatcher<I> {

    override fun dispatch(action: I) {
        CoroutineScope(coroutineDispatcher).launch {
            store.inputState.emit(action)
        }
    }
}