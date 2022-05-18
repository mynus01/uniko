package com.mynus01.firesns.state.dispatcher

import com.mynus01.firesns.state.action.InputAction

interface Dispatcher<I: InputAction> {
    fun dispatch(action: I)
}