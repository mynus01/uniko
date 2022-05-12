package com.mynus01.firesns.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
class ProviderModule {
    @Provides
    @DispatcherMain
    fun dispatcherMainProvider(): CoroutineDispatcher = Dispatchers.Main

    @Provides
    @DispatcherIO
    fun dispatcherIOProvider(): CoroutineDispatcher = Dispatchers.IO
}