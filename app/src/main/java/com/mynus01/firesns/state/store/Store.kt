package com.mynus01.firesns.state.store

import com.mynus01.firesns.state.action.InputAction
import com.mynus01.firesns.state.action.OutputAction
import kotlinx.coroutines.flow.MutableStateFlow

interface Store {
    val inputState: MutableStateFlow<InputAction>
    val outputState: MutableStateFlow<OutputAction>

    fun init()
    fun reduce(action: InputAction): OutputAction
}