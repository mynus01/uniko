package com.mynus01.firesns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun signUp(email: String, password: String) {
        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this,::onSignUpComplete)
            .addOnSuccessListener(this, ::onSignUpSuccess)
            .addOnFailureListener(this, ::onSignUpError)
    }

    fun onSignUpComplete(task: Task<AuthResult>) {}
    fun onSignUpSuccess(authResult: AuthResult?) {
        val currentUser = FirebaseAuth.getInstance().currentUser
    }
    fun onSignUpError(exception: Exception) {
        when(exception) {
            is FirebaseAuthException -> {}
            is FirebaseAuthUserCollisionException -> {}
            is FirebaseAuthInvalidCredentialsException -> {}
            is FirebaseAuthWeakPasswordException -> {}
            else -> {}
        }
    }

    fun signIn(email: String, password: String) {
        FirebaseAuth.getInstance()
            .signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this,::onSignInComplete)
            .addOnSuccessListener(this, ::onSignInSuccess)
            .addOnFailureListener(this, ::onSignInError)
    }

    fun onSignInComplete(task: Task<AuthResult>) {}
    fun onSignInSuccess(authResult: AuthResult?) {
        val currentUser = FirebaseAuth.getInstance().currentUser
    }
    fun onSignInError(exception: Exception) {}
}