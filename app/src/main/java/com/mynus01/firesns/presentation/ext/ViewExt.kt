package com.mynus01.firesns.presentation.ext

import com.mynus01.firesns.data.interactor.InteractorState
import com.mynus01.firesns.presentation.domain.ViewState

fun InteractorState.toViewState(): ViewState {
    return when (this) {
        is InteractorState.Idle -> ViewState.Init
        is InteractorState.Loading -> ViewState.Loading
        is InteractorState.Complete -> {
            when(this) {
                is InteractorState.Complete.Empty -> ViewState.Complete.Empty
                is InteractorState.Complete.Success<*> -> ViewState.Complete.Success(this.data)
                is InteractorState.Complete.Fail -> ViewState.Complete.Fail(this.exception)
            }
        }
    }
}