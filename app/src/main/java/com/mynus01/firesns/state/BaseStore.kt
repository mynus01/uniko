package com.mynus01.firesns.state

interface BaseStore {
    fun dispatch(action: Action)
    fun reduce(action: Action)
}