package com.mynus01.firesns.data.interactor

import com.mynus01.firesns.data.repository.FirebaseAuthRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.lang.Exception
import java.util.concurrent.Executor
import javax.inject.Inject

class FirebaseAuthInteractorImpl @Inject constructor(
    private val authRepository: FirebaseAuthRepository
) : FirebaseAuthInteractor {
    override suspend fun signUp(email: String, password: String) = flow {
        emit(InteractorState.Loading)
        try {
            authRepository.signUp(email, password).await().user?.also { user ->
                emit(InteractorState.Complete.Success(user))
            } ?: emit(InteractorState.Complete.Empty)
        } catch (e: Exception) {
            emit(InteractorState.Complete.Fail(e))
        }
    }
}