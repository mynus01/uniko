package com.mynus01.firesns.di

import com.mynus01.firesns.presentation.uniko.store.AppStore
import com.mynus01.firesns.presentation.uniko.action.InAction
import com.mynus01.firesns.presentation.uniko.action.OutAction
import com.mynus01.firesns.presentation.uniko.dispatcher.AppDispatcher
import com.mynus01.firesns.presentation.uniko.receiver.AppReceiver
import com.mynus01.uniko.action.InputAction
import com.mynus01.uniko.action.OutputAction
import com.mynus01.uniko.dispatcher.Dispatcher
import com.mynus01.uniko.receiver.Receiver
import com.mynus01.uniko.store.Store
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface UniModule {
    @Binds
    @Singleton
    fun myStoreProvider(store: AppStore): Store<InputAction, OutputAction>

    @Binds
    fun receiverProvider(receiver: AppReceiver): Receiver

    @Binds
    fun dispatcherProvider(dispatcher: AppDispatcher): Dispatcher<InputAction>
}