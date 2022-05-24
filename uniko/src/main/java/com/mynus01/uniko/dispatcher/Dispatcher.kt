package com.mynus01.uniko.dispatcher

import com.mynus01.uniko.action.InputAction

interface Dispatcher<I: InputAction> {
    fun dispatch(action: I)
}