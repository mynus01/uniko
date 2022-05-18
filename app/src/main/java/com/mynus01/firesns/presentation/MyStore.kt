package com.mynus01.firesns.presentation

import com.mynus01.firesns.di.DispatcherMain
import com.mynus01.firesns.presentation.action.InAction
import com.mynus01.firesns.presentation.action.OutAction
import com.mynus01.firesns.presentation.reducer.SignUpReducer
import com.mynus01.firesns.state.store.StoreImpl
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class MyStore @Inject constructor(
    @DispatcherMain
    dispatcher: CoroutineDispatcher
) : StoreImpl<InAction, OutAction>(dispatcher) {
    override fun reduce(action: InAction): OutAction {
        return when (action) {
            is InAction.InitInput -> OutAction.InitOutput
            is InAction.SignUpInput -> SignUpReducer().reduce(action)
        }
    }
}