package com.mynus01.firesns.state

import com.mynus01.firesns.state.action.OutputAction
import com.mynus01.firesns.state.store.AppStore
import kotlinx.coroutines.flow.collect

suspend fun receive(action: suspend (value: OutputAction) -> Unit) {
    return AppStore.outputState.collect(action)
}