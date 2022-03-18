package com.mynus01.firesns.state.store

import com.mynus01.firesns.state.action.InputAction
import com.mynus01.firesns.state.action.OutputAction
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect

object AppStore {
    val inputState = MutableStateFlow<InputAction>(InputAction.InitInput)
    val outputState = MutableStateFlow<OutputAction>(OutputAction.InitOutput)

    fun init() {
        CoroutineScope(Dispatchers.Main).launch {
            inputState.collect { action ->
                outputState.value = reduce(action)
            }
        }
    }
}