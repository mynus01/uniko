package com.mynus01.firesns.presentation.viewmodel

import androidx.lifecycle.*
import com.mynus01.firesns.di.DispatcherMain
import com.mynus01.firesns.domain.ViewState
import com.mynus01.firesns.state.receiver.Receiver
import com.mynus01.firesns.presentation.action.OutAction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    @DispatcherMain
    private val dispatcher: CoroutineDispatcher,
    private val receiver: Receiver
) : ViewModel() {
    var email = MutableLiveData("")
    var password = MutableLiveData("")
    var viewStateLiveData = MutableLiveData<ViewState>(ViewState.Init)

    init {
        CoroutineScope(dispatcher).launch {
            receiver.observe(OutAction.SignUpOutput::class)?.collect { action ->
                action.viewState.collect { state ->
                    viewStateLiveData.value = state
                }
            }
        }
    }
}