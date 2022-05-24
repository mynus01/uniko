package com.mynus01.uniko.reducer

interface Reducer<I, O> {
    fun reduce(action: I): O
}