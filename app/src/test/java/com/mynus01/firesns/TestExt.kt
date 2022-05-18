package com.mynus01.firesns

import app.cash.turbine.test
import kotlinx.coroutines.flow.Flow

suspend inline fun <T> Flow<T>.testCollect(
    consumeRemaining: Boolean = false,
    crossinline onCollect: (item: T) -> Unit
) {
    test {
        onCollect.invoke(awaitItem())

        if (consumeRemaining) {
            cancelAndConsumeRemainingEvents()
        } else {
            cancelAndIgnoreRemainingEvents()
        }
    }
}