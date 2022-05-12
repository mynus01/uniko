package com.mynus01.firesns.state.reducer

import com.mynus01.firesns.state.action.InputAction
import com.mynus01.firesns.state.action.OutputAction

interface Reducer<I: InputAction, O: OutputAction> {
    fun reduce(action: I): O
}