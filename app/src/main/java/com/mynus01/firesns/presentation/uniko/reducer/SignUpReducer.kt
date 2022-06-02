package com.mynus01.firesns.presentation.uniko.reducer

import com.mynus01.firesns.presentation.uniko.action.input.SignUpInput
import com.mynus01.firesns.presentation.uniko.action.output.SignUpOutput
import com.mynus01.uniko.reducer.Reducer

class SignUpReducer : Reducer<SignUpInput, SignUpOutput> {
    override fun reduce(action: SignUpInput): SignUpOutput {
        action.apply {
            return SignUpOutput(interactor.signUp(email, password))
        }
    }
}
