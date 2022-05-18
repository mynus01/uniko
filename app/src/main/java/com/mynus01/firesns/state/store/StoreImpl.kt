package com.mynus01.firesns.state.store

import com.mynus01.firesns.state.action.InputAction
import com.mynus01.firesns.state.action.OutputAction
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect

abstract class StoreImpl<I: InputAction, O: OutputAction>(
    dispatcher: CoroutineDispatcher
) : Store<I, O> {
    override val inputState = MutableSharedFlow<I>()
    override val outputState = MutableSharedFlow<O>()

    init {
        CoroutineScope(dispatcher).launch {
            inputState.collect { action ->
                outputState.emit(reduce(action))
            }
        }
    }
}