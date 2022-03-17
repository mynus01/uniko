package com.mynus01.firesns.datasource.interactor

import com.mynus01.firesns.datasource.repository.FirebaseAuthRepository
import com.mynus01.firesns.domain.ViewState
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseAuthInteractorImpl @Inject constructor(
    private val authRepository: FirebaseAuthRepository
) : FirebaseAuthInteractor {
    override fun signUp(email: String, password: String) = flow {
        emit(ViewState.Loading)
        authRepository.signUp(email, password).await().user?.also { user ->
            emit(ViewState.Complete.Success(user))
        } ?: emit(ViewState.Complete.Empty)
    }.catch { e ->
        emit(ViewState.Complete.Fail(e))
    }.flowOn(Dispatchers.IO)
}