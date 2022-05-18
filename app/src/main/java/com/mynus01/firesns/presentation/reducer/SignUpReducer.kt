package com.mynus01.firesns.presentation.reducer

import com.mynus01.firesns.presentation.action.InAction
import com.mynus01.firesns.presentation.action.OutAction
import com.mynus01.firesns.state.reducer.Reducer

class SignUpReducer : Reducer<InAction.SignUpInput, OutAction.SignUpOutput> {
    override fun reduce(action: InAction.SignUpInput): OutAction.SignUpOutput {
        action.apply {
            return OutAction.SignUpOutput(interactor.signUp(email, password))
        }
    }
}
