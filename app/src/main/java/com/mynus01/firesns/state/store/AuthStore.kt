package com.mynus01.firesns.state.store

import com.mynus01.firesns.state.action.CreateStoreAction
import com.mynus01.firesns.state.domain.Action
import com.mynus01.firesns.state.domain.Store
import kotlinx.coroutines.flow.MutableStateFlow

object AuthStore: Store() {
    override val state = MutableStateFlow<Action>(CreateStoreAction())

    init {
        addToAppStore()
    }
}