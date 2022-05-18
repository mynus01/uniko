package com.mynus01.firesns.state.receiver

import com.mynus01.firesns.di.DispatcherMain
import com.mynus01.firesns.state.action.InputAction
import com.mynus01.firesns.state.action.OutputAction
import com.mynus01.firesns.state.store.Store
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import kotlin.reflect.KClass

class ReceiverImpl<I: InputAction, O: OutputAction> @Inject constructor(
    @DispatcherMain
    private val coroutineDispatcher: CoroutineDispatcher,
    private val store: Store<I, O>
) : Receiver {
    private val map: MutableMap<KClass<OutputAction>, MutableSharedFlow<OutputAction>> = mutableMapOf()

    override suspend fun <T : OutputAction> observe(clazz: KClass<T>): SharedFlow<T>? {
        clazz as KClass<OutputAction>

        if (!map.containsKey(clazz)) {
            map[clazz] = MutableSharedFlow()
        }
        CoroutineScope(coroutineDispatcher).launch {
            store.outputState.collect { action ->
                if (action::class == clazz) {
                    map[clazz]?.emit(action)
                }
            }
        }
        return map[clazz]?.asSharedFlow() as? SharedFlow<T>?
    }
}