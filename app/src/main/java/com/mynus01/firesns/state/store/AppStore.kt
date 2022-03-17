package com.mynus01.firesns.state.store

import com.mynus01.firesns.state.action.CreateStoreAction
import com.mynus01.firesns.state.domain.Action
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking

object AppStore {
    val appState = MutableStateFlow<MutableSet<Action>>(mutableSetOf())

    init {
        runBlocking {
            appState.collect { set ->
                when {
                    set.contains(CreateStoreAction()) -> {
                        //TODO: reducers
                    }
                    else -> {}
                }
            }
        }
    }
}