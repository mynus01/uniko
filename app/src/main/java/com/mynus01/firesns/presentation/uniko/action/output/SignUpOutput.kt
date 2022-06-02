package com.mynus01.firesns.presentation.uniko.action.output

import com.mynus01.firesns.domain.ViewState
import com.mynus01.uniko.action.OutputAction
import kotlinx.coroutines.flow.Flow

class SignUpOutput(
    val viewState: Flow<ViewState>
) : OutputAction