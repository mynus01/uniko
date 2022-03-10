package com.mynus01.firesns.data.provider

import com.google.firebase.auth.FirebaseAuth

interface FirebaseAuthProvider {
    fun init(): FirebaseAuth
}