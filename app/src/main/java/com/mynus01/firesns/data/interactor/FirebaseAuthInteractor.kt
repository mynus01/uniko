package com.mynus01.firesns.data.interactor

import kotlinx.coroutines.flow.Flow

interface FirebaseAuthInteractor {
    suspend fun signUp(email: String, password: String): Flow<InteractorState>
}