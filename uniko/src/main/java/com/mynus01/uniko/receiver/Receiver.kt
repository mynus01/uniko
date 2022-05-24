package com.mynus01.uniko.receiver

import com.mynus01.uniko.action.OutputAction
import kotlinx.coroutines.flow.SharedFlow
import kotlin.reflect.KClass

interface Receiver {
    suspend fun <T : OutputAction> observe(clazz: KClass<T>): SharedFlow<T>?
}