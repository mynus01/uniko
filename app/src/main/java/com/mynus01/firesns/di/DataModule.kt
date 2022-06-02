package com.mynus01.firesns.di

import com.mynus01.firesns.datasource.interactor.AuthInteractor
import com.mynus01.firesns.datasource.interactor.AuthInteractorImpl
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
    fun authInteractorProvider(impl: AuthInteractorImpl): AuthInteractor
}