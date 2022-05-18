package com.mynus01.firesns.presentation.action

import com.mynus01.firesns.datasource.interactor.FirebaseAuthInteractor
import com.mynus01.firesns.state.action.InputAction

sealed class InAction : InputAction {
    object InitInput : InAction()
    class SignUpInput(
        val interactor: FirebaseAuthInteractor,
        val email: String,
        val password: String
    ) : InAction()
}