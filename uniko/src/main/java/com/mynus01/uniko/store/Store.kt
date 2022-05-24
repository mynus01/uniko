package com.mynus01.uniko.store

import com.mynus01.uniko.action.InputAction
import com.mynus01.uniko.action.OutputAction
import kotlinx.coroutines.flow.MutableSharedFlow

interface Store<I: InputAction, O: OutputAction> {
    val inputState: MutableSharedFlow<I>
    val outputState: MutableSharedFlow<O>

    fun reduce(action: I): O
}