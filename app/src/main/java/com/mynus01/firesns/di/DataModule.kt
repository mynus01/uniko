package com.mynus01.firesns.di

import com.mynus01.firesns.datasource.interactor.FirebaseAuthInteractor
import com.mynus01.firesns.datasource.interactor.FirebaseAuthInteractorImpl
import com.mynus01.firesns.datasource.provider.FirebaseAuthProvider
import com.mynus01.firesns.datasource.provider.FirebaseAuthProviderImpl
import com.mynus01.firesns.datasource.repository.FirebaseAuthRepository
import com.mynus01.firesns.datasource.repository.FirebaseAuthRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    @Singleton
    fun firebaseAuthProvider(impl: FirebaseAuthProviderImpl): FirebaseAuthProvider

    @Binds
    @Singleton
    fun firebaseAuthRepositoryProvider(impl: FirebaseAuthRepositoryImpl): FirebaseAuthRepository

    @Binds
    @Singleton
    fun firebaseAuthInteractorProvider(impl: FirebaseAuthInteractorImpl): FirebaseAuthInteractor
}