package com.mynus01.firesns.data.interactor


sealed class InteractorState {
    object Idle : InteractorState()
    object Loading : InteractorState()
    sealed class Complete : InteractorState() {
        object Empty : Complete()
        class Success<T>(val data: T) : Complete()
        class Fail(val exception: Throwable) : Complete()
    }
}