package com.mynus01.firesns.presentation.action

import com.mynus01.firesns.domain.ViewState
import com.mynus01.firesns.state.action.OutputAction
import kotlinx.coroutines.flow.Flow

sealed class OutAction: OutputAction {
    object InitOutput: OutAction()
    class SignUpOutput(val viewState: Flow<ViewState>) : OutAction()
}