package com.mynus01.uniko.receiver

import com.mynus01.uniko.extension.launch
import com.mynus01.uniko.action.InputAction
import com.mynus01.uniko.action.OutputAction
import com.mynus01.uniko.store.Store
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.reflect.KClass

open class BaseReceiver<I: InputAction, O: OutputAction>(
    private val store: Store<I, O>,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.Main,

) : Receiver {
    private val map: MutableMap<KClass<OutputAction>, MutableSharedFlow<OutputAction>> = mutableMapOf()

    override suspend fun <T : OutputAction> observe(clazz: KClass<T>): SharedFlow<T>? {
        clazz as KClass<OutputAction>

        if (!map.containsKey(clazz)) {
            map[clazz] = MutableSharedFlow()
        }
        launch(coroutineDispatcher) {
            store.outputState.collect { action ->
                if (action::class == clazz) {
                    map[clazz]?.emit(action)
                }
            }
        }
        return map[clazz]?.asSharedFlow() as? SharedFlow<T>?
    }
}