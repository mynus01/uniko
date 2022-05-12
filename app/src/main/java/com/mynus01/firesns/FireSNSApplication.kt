package com.mynus01.firesns

import android.app.Application
import com.mynus01.firesns.state.store.Store
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class FireSNSApplication : Application() {
    @Inject lateinit var appStore: Store

    override fun onCreate() {
        super.onCreate()
        appStore.init()
    }
}