package com.mynus01.firesns.state.store

import com.mynus01.firesns.di.DispatcherMain
import com.mynus01.firesns.state.action.InputAction
import com.mynus01.firesns.state.action.OutputAction
import com.mynus01.firesns.state.reducer.SignUpReducer
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class AppStore @Inject constructor(
    @DispatcherMain
    private val dispatcher: CoroutineDispatcher
) : Store {
    override val inputState = MutableSharedFlow<InputAction>()
    override val outputState = MutableSharedFlow<OutputAction>()

    override fun init() {
        CoroutineScope(dispatcher).launch {
            inputState.collect { action ->
                outputState.emit(reduce(action))
            }
            inputState.emit(InputAction.InitInput)
        }
    }

    override fun reduce(action: InputAction): OutputAction {
        return when (action) {
            is InputAction.InitInput -> OutputAction.InitOutput
            is InputAction.SignUpInput -> SignUpReducer().reduce(action)
        }
    }
}