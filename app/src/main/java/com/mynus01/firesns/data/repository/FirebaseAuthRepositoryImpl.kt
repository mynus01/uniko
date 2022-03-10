package com.mynus01.firesns.data.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.mynus01.firesns.data.provider.FirebaseAuthProvider
import javax.inject.Inject

class FirebaseAuthRepositoryImpl @Inject constructor(
    private val authProvider: FirebaseAuthProvider
) : FirebaseAuthRepository {
    override fun signUp(email: String, password: String): Task<AuthResult> {
        return authProvider.init().createUserWithEmailAndPassword(email, password)
    }
}