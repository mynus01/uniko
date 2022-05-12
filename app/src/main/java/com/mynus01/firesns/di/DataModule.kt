package com.mynus01.firesns.di

import com.mynus01.firesns.datasource.interactor.FirebaseAuthInteractor
import com.mynus01.firesns.datasource.interactor.FirebaseAuthInteractorImpl
import com.mynus01.firesns.datasource.provider.FirebaseAuthProvider
import com.mynus01.firesns.datasource.provider.FirebaseAuthProviderImpl
import com.mynus01.firesns.datasource.repository.FirebaseAuthRepository
import com.mynus01.firesns.datasource.repository.FirebaseAuthRepositoryImpl
import com.mynus01.firesns.state.dispatcher.Dispatcher
import com.mynus01.firesns.state.dispatcher.DispatcherImpl
import com.mynus01.firesns.state.receiver.Receiver
import com.mynus01.firesns.state.receiver.ReceiverImpl
import com.mynus01.firesns.state.store.Store
import com.mynus01.firesns.state.store.AppStore
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
    fun appStoreProvider(store: AppStore): Store

    @Binds
    fun receiverProvider(receiver: ReceiverImpl): Receiver

    @Binds
    fun dispatcherProvider(dispatcher: DispatcherImpl): Dispatcher

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