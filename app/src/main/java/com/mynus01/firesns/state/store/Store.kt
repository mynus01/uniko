package com.mynus01.firesns.state.store

import com.mynus01.firesns.state.action.InputAction
import com.mynus01.firesns.state.action.OutputAction
import kotlinx.coroutines.flow.MutableSharedFlow

interface Store<I: InputAction, O: OutputAction> {
    val inputState: MutableSharedFlow<I>
    val outputState: MutableSharedFlow<O>

    fun reduce(action: I): O
}