package com.mynus01.firesns.state.action

import com.mynus01.firesns.domain.ViewState
import kotlinx.coroutines.flow.Flow

sealed class OutputAction {
    object InitOutput: OutputAction()
    class SignUpOutput(val state: Flow<ViewState>) : OutputAction()
}