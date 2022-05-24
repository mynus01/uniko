package com.mynus01.uniko.extension

import com.mynus01.uniko.action.OutputAction
import com.mynus01.uniko.receiver.Receiver
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlin.reflect.KClass

fun launch(
    dispatcher: CoroutineDispatcher = Dispatchers.Main,
    action: suspend () -> Unit
): Job {
    return CoroutineScope(dispatcher).launch(dispatcher) {
        action.invoke()
    }
}

fun <T : OutputAction> Receiver.observe(
    action: KClass<T>,
    dispatcher: CoroutineDispatcher = Dispatchers.Main,
    onActionReceive: (action: T) -> Unit
): Job {
    return launch(dispatcher) {
        observe(action)?.collect { action ->
            onActionReceive.invoke(action)
        }
    }
}