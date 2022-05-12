package com.mynus01.firesns.domain

sealed class ViewState {
    object Init : ViewState()
    object Loading : ViewState()
    sealed class Complete : ViewState() {
        object Empty : Complete()
        class Success<T>(val data: T) : Complete()
        class Fail(val exception: Throwable) : Complete()
    }
}