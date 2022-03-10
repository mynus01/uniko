package com.mynus01.firesns.presentation.state

sealed class ViewState {
    object Idle : ViewState()
    object Loading : ViewState()
    object Complete : ViewState()
    class Success<T>(val data: T?) : ViewState()
    class Fail(val exception: Throwable) : ViewState()
}