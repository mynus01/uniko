package com.mynus01.firesns.presentation.uniko.reducer

import com.mynus01.firesns.presentation.uniko.action.InAction
import com.mynus01.firesns.presentation.uniko.action.OutAction
import com.mynus01.uniko.reducer.Reducer

class SignUpReducer : Reducer<InAction.SignUpInput, OutAction.SignUpOutput> {
    override fun reduce(action: InAction.SignUpInput): OutAction.SignUpOutput {
        action.apply {
            return OutAction.SignUpOutput(interactor.signUp(email, password))
        }
    }
}
