package com.mynus01.uniko.mock.store

import com.mynus01.uniko.action.InputAction
import com.mynus01.uniko.action.OutputAction
import com.mynus01.uniko.mock.action.input.TestInput
import com.mynus01.uniko.mock.action.output.TestOutput
import com.mynus01.uniko.store.BaseStore
import kotlinx.coroutines.CoroutineDispatcher

class MockStore(
    dispatcher: CoroutineDispatcher
) : BaseStore<InputAction, OutputAction>(dispatcher) {
    override fun reduce(action: InputAction): OutputAction {
        return when (action) {
            is TestInput -> TestOutput
            else -> throw IllegalArgumentException("Unhandled action!")
        }
    }
}