package com.mynus01.firesns

import android.app.Application
import com.mynus01.firesns.presentation.state.action.InAction
import com.mynus01.firesns.presentation.state.action.OutAction
import com.mynus01.firesns.state.store.Store
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class FireSNSApplication : Application() {
    @Inject
    lateinit var appStore: Store<InAction, OutAction>
}