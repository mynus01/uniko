package com.mynus01.firesns.state

import com.mynus01.firesns.state.domain.Action
import com.mynus01.firesns.state.domain.Store
import com.mynus01.firesns.state.store.AppStore.appState

fun Action.dispatch(store: Store) {
    appState.value.add(this)
    store.state.value = this
}