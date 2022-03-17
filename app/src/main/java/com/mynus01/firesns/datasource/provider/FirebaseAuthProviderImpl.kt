package com.mynus01.firesns.datasource.provider

import com.google.firebase.auth.*
import javax.inject.Inject

class FirebaseAuthProviderImpl @Inject constructor() : FirebaseAuthProvider {
    override fun init(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }
}