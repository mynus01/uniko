package com.mynus01.firesns.state.receiver

import com.mynus01.firesns.state.action.OutputAction

interface Receiver {
    suspend fun observe(action: suspend (value: OutputAction) -> Unit)
}