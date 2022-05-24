package com.mynus01.firesns

import android.app.Application
import com.mynus01.uniko.action.InputAction
import com.mynus01.uniko.action.OutputAction
import com.mynus01.uniko.store.Store
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class FireSNSApplication : Application() {
    @Inject
    lateinit var appStore: Store<InputAction, OutputAction>
}