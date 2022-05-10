package com.mynus01.firesns.state.store

import com.mynus01.firesns.di.DispatcherMain
import com.mynus01.firesns.state.action.InputAction
import com.mynus01.firesns.state.action.OutputAction
import com.mynus01.firesns.state.reducer.SignUpReducer
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class AppStore @Inject constructor(
    @DispatcherMain
    private val dispatcher: CoroutineDispatcher
) : Store {
    override val inputState = MutableStateFlow<InputAction>(InputAction.InitInput)
    override val outputState = MutableStateFlow<OutputAction>(OutputAction.InitOutput)

    override fun init() {
        CoroutineScope(dispatcher).launch {
            inputState.collect { action ->
                outputState.value = reduce(action)
            }
        }
    }

    override fun reduce(action: InputAction): OutputAction {
        return when (action) {
            is InputAction.InitInput -> OutputAction.InitOutput
            is InputAction.SignUpInput -> SignUpReducer().reduce(action)
        }
    }
}