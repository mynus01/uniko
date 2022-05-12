package com.mynus01.firesns.state.dispatcher

import com.mynus01.firesns.state.action.InputAction
import com.mynus01.firesns.state.action.OutputAction

interface Dispatcher {
    fun dispatch(action: InputAction)
}