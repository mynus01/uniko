package com.mynus01.firesns.data.interactor

import com.mynus01.firesns.data.repository.FirebaseAuthRepository
import java.lang.Exception
import java.util.concurrent.Executor
import javax.inject.Inject

class FirebaseAuthInteractorImpl @Inject constructor(
    private val authRepository: FirebaseAuthRepository
) : FirebaseAuthInteractor {
    override suspend fun signUp(executor: Executor, email: String, password: String, output: FirebaseAuthInteractorOutput) {
        output.collectInteractorState(InteractorState.Loading)

        try {
            authRepository.signUp(email, password)
                .addOnCompleteListener(executor) {
                    output.collectInteractorState(InteractorState.Loading)
                }
                .addOnSuccessListener(executor) { authResult ->
                    output.collectInteractorState(InteractorState.Success(authResult?.user))
                }
                .addOnFailureListener(executor) { exception ->
                    output.collectInteractorState(InteractorState.Fail(exception))
                }
        } catch (e: Exception) {
            output.collectInteractorState(InteractorState.Fail(e))
        }
    }
}