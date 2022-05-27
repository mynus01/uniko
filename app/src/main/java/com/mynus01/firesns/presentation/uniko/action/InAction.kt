package com.mynus01.firesns.presentation.uniko.action

import com.mynus01.firesns.datasource.interactor.FirebaseAuthInteractor
import com.mynus01.uniko.action.InputAction

sealed class InAction : InputAction {
    object InitInput : InAction()
    class SignUpInput(
        val interactor: FirebaseAuthInteractor,
        val email: String,
        val password: String
    ) : InAction()
}