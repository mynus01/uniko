package com.mynus01.uniko.store

import com.mynus01.uniko.extension.launch
import com.mynus01.uniko.action.InputAction
import com.mynus01.uniko.action.OutputAction
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect

abstract class BaseStore<I: InputAction, O: OutputAction>(
    dispatcher: CoroutineDispatcher = Dispatchers.Main
) : Store<I, O> {
    override val inputState = MutableSharedFlow<I>()
    override val outputState = MutableSharedFlow<O>()

    init {
        launch(dispatcher) {
            inputState.collect { action ->
                outputState.emit(reduce(action))
            }
        }
    }
}