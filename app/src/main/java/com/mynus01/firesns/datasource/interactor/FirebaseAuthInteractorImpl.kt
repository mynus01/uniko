package com.mynus01.firesns.datasource.interactor

import com.mynus01.firesns.datasource.repository.FirebaseAuthRepository
import com.mynus01.firesns.di.DispatcherIO
import com.mynus01.firesns.domain.ViewState
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class FirebaseAuthInteractorImpl @Inject constructor(
    @DispatcherIO
    private val dispatcher: CoroutineDispatcher,
    private val authRepository: FirebaseAuthRepository
) : FirebaseAuthInteractor {
    override fun signUp(email: String, password: String) = flow {
        emit(ViewState.Loading)
//        authRepository.signUp(email, password).await().user?.also { user ->
//            emit(ViewState.Complete.Success(user))
//        } ?: emit(ViewState.Complete.Empty)
        emit(mockSignUp(email, password))
    }.catch { e ->
        emit(ViewState.Complete.Fail(e))
    }.flowOn(dispatcher)

    private fun mockSignUp(email: String, password: String): ViewState {
        val errorMessage: String = if (email.isNotBlank()) {
            if (email.length >= 6) {
                if (email.contains('@', true) && email.contains('.', true)) {
                    if (password.isNotBlank()) {
                        if (password.length >= 6) {
                            return ViewState.Complete.Success("Logged in successfully")
                        } else {
                            "Password must have at least 6 digits"
                        }
                    } else {
                        "Password can't be blank"
                    }
                } else {
                    "Please insert a valid e-mail"
                }
            } else {
                "E-mail must have at least 6 digits"
            }
        } else {
            "E-mail can't be blank"
        }
        return ViewState.Complete.Fail(IllegalArgumentException(errorMessage))
    }
}