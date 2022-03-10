package com.mynus01.firesns.data.interactor

sealed class InteractorState {
    object Idle : InteractorState()
    object Loading : InteractorState()
    object Complete : InteractorState()
    class Success<T>(val data: T?) : InteractorState()
    class Fail(val exception: Throwable) : InteractorState()
}