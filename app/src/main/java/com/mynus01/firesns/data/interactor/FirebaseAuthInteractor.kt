package com.mynus01.firesns.data.interactor

import java.util.concurrent.Executor

interface FirebaseAuthInteractor {
    suspend fun signUp(executor: Executor, email: String, password: String, output: FirebaseAuthInteractorOutput)
}