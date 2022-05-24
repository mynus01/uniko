package com.mynus01.firesns.presentation.uniko.dispatcher

import com.mynus01.uniko.action.InputAction
import com.mynus01.uniko.action.OutputAction
import com.mynus01.uniko.dispatcher.BaseDispatcher
import com.mynus01.uniko.store.Store
import javax.inject.Inject

class AppDispatcher @Inject constructor(
    store: Store<InputAction, OutputAction>
) : BaseDispatcher<InputAction, OutputAction>(store)