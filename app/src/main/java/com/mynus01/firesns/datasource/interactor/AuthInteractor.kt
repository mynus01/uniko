package com.mynus01.firesns.datasource.interactor

import com.mynus01.firesns.domain.ViewState
import kotlinx.coroutines.flow.Flow

interface AuthInteractor {
    fun signUp(email: String, password: String): Flow<ViewState>
}