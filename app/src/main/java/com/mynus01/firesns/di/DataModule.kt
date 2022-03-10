package com.mynus01.firesns.di

import androidx.lifecycle.ViewModel
import com.mynus01.firesns.data.interactor.FirebaseAuthInteractor
import com.mynus01.firesns.data.interactor.FirebaseAuthInteractorImpl
import com.mynus01.firesns.data.provider.FirebaseAuthProvider
import com.mynus01.firesns.data.provider.FirebaseAuthProviderImpl
import com.mynus01.firesns.data.repository.FirebaseAuthRepository
import com.mynus01.firesns.data.repository.FirebaseAuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    @Singleton
    fun firebaseAuthProvider(): FirebaseAuthProvider {
        return FirebaseAuthProviderImpl()
    }

    @Provides
    @Singleton
    fun firebaseAuthRepository(authProvider: FirebaseAuthProvider): FirebaseAuthRepository {
        return FirebaseAuthRepositoryImpl(authProvider)
    }

    @Provides
    @Singleton
    fun firebaseAuthInteractor(firebaseAuthRepository: FirebaseAuthRepository): FirebaseAuthInteractor{
        return FirebaseAuthInteractorImpl(firebaseAuthRepository)
    }
}