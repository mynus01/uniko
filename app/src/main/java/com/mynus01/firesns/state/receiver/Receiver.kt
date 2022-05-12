package com.mynus01.firesns.state.receiver

import com.mynus01.firesns.state.action.OutputAction
import kotlinx.coroutines.flow.SharedFlow
import kotlin.reflect.KClass

interface Receiver {
    suspend fun <T : OutputAction> observe(clazz: KClass<T>): SharedFlow<T>?
}