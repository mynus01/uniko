package com.mynus01.firesns.state.action

import com.mynus01.firesns.datasource.interactor.FirebaseAuthInteractor

sealed class InputAction {
    object InitInput : InputAction()
    class SignUpInput(
        val interactor: FirebaseAuthInteractor,
        val email: String,
        val password: String
    ) : InputAction()
}