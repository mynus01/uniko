package com.mynus01.firesns.presentation.uniko.receiver

import com.mynus01.firesns.di.DispatcherMain
import com.mynus01.uniko.action.InputAction
import com.mynus01.uniko.action.OutputAction
import com.mynus01.uniko.receiver.BaseReceiver
import com.mynus01.uniko.store.Store
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class AppReceiver @Inject constructor(
    store: Store<InputAction, OutputAction>,
    @DispatcherMain
    dispatcher: CoroutineDispatcher
) : BaseReceiver<InputAction, OutputAction>(store, dispatcher)