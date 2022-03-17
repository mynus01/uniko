package com.mynus01.firesns.state.domain

import com.mynus01.firesns.state.store.AppStore.appState
import kotlinx.coroutines.flow.MutableStateFlow

abstract class Store {
    abstract val state: MutableStateFlow<Action>

    fun addToAppStore() {
        appState.value.add(state)
    }
}