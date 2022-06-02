package com.mynus01.firesns.presentation.uniko.action.input

import com.mynus01.firesns.datasource.interactor.AuthInteractor
import com.mynus01.uniko.action.InputAction

class SignUpInput(
    val interactor: AuthInteractor,
    val email: String,
    val password: String
) : InputAction