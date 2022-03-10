package com.mynus01.firesns.data.interactor

import kotlinx.coroutines.flow.StateFlow
import java.util.concurrent.Executor
import javax.inject.Singleton

interface FirebaseAuthInteractor {
    suspend fun signUp(executor: Executor, email: String, password: String, output: FirebaseAuthInteractorOutput)
}