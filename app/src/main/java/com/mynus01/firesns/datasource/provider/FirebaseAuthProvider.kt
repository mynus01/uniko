package com.mynus01.firesns.datasource.provider

import com.google.firebase.auth.FirebaseAuth

interface FirebaseAuthProvider {
    fun init(): FirebaseAuth
}