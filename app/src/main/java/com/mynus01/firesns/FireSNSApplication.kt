package com.mynus01.firesns

import android.app.Application
import com.mynus01.firesns.state.store.AppStore
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FireSNSApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppStore.init()
    }
}