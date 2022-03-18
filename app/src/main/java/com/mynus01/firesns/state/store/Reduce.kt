package com.mynus01.firesns.state.store

import android.util.Log
import com.mynus01.firesns.state.action.InputAction
import com.mynus01.firesns.state.action.OutputAction
import com.mynus01.firesns.state.reducer.signUpReducer

fun reduce(action: InputAction): OutputAction {
    Log.d("Action", action::class.simpleName ?: "Unknown")
    return when (action) {
        is InputAction.InitInput -> OutputAction.InitOutput
        is InputAction.SignUpInput -> signUpReducer(action)
    }
}