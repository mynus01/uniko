package com.mynus01.firesns.state.store

import android.util.Log
import com.mynus01.firesns.state.action.InputAction
import com.mynus01.firesns.state.action.OutputAction
import com.mynus01.firesns.state.reducer.SignUpReducer
import com.mynus01.firesns.state.store.Store
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class AppStore @Inject constructor(): Store {
    override val inputState = MutableStateFlow<InputAction>(InputAction.InitInput)
    override val outputState = MutableStateFlow<OutputAction>(OutputAction.InitOutput)

    override fun init() {
        CoroutineScope(Dispatchers.Main).launch {
            inputState.collect { action ->
                outputState.value = reduce(action)
            }
        }
    }

    override fun reduce(action: InputAction): OutputAction {
        Log.d("Action", action::class.simpleName ?: "Unknown")
        return when (action) {
            is InputAction.InitInput -> OutputAction.InitOutput
            is InputAction.SignUpInput -> SignUpReducer().reduce(action)
        }
    }
}