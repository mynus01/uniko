package com.mynus01.firesns.data.provider

import com.google.firebase.auth.*

class FirebaseAuthProviderImpl: FirebaseAuthProvider {
    override fun init(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }
}