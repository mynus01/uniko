package com.mynus01.firesns.state

import com.mynus01.firesns.state.action.InputAction
import com.mynus01.firesns.state.action.OutputAction
import com.mynus01.firesns.state.store.AppStore.inputState
import com.mynus01.firesns.state.store.AppStore.outputState

fun dispatch(action: InputAction) {
    inputState.value = action
}

//fun outputDispatch(action: OutputAction) {
//    outputState.value = action
//}