package com.mynus01.firesns.presentation.uniko.store

import com.mynus01.firesns.di.DispatcherMain
import com.mynus01.firesns.presentation.uniko.action.InAction
import com.mynus01.firesns.presentation.uniko.action.OutAction
import com.mynus01.firesns.presentation.uniko.reducer.SignUpReducer
import com.mynus01.uniko.action.InputAction
import com.mynus01.uniko.action.OutputAction
import com.mynus01.uniko.store.BaseStore
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class AppStore @Inject constructor(
    @DispatcherMain
    coroutineDispatcher: CoroutineDispatcher
) : BaseStore<InputAction, OutputAction>(coroutineDispatcher) {
    override fun reduce(action: InputAction): OutputAction {
        return when (action) {
            is InAction.InitInput -> OutAction.InitOutput
            is InAction.SignUpInput -> SignUpReducer().reduce(action)
            else -> throw IllegalArgumentException("Unhandled action!")
        }
    }
}