package com.mynus01.firesns.state.reducer

import com.mynus01.firesns.state.action.InputAction
import com.mynus01.firesns.state.action.OutputAction

fun signUpReducer(action: InputAction.SignUpInput): OutputAction.SignUpOutput {
    action.apply {
        return OutputAction.SignUpOutput(interactor.signUp(email, password))
    }
}