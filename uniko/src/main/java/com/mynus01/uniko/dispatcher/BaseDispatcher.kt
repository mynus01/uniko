package com.mynus01.uniko.dispatcher

import com.mynus01.uniko.action.InputAction
import com.mynus01.uniko.action.OutputAction
import com.mynus01.uniko.extension.launch
import com.mynus01.uniko.store.Store
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

open class BaseDispatcher<I: InputAction, O: OutputAction>(
    private val store: Store<I, O>,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.Main
) : Dispatcher<I> {
    override fun dispatch(action: I) {
        launch(coroutineDispatcher) {
            store.inputState.emit(action)
        }
    }
}