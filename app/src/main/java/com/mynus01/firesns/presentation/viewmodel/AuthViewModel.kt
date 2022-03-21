package com.mynus01.firesns.presentation.viewmodel

import androidx.lifecycle.*
import com.mynus01.firesns.domain.ViewState
import com.mynus01.firesns.state.receiver.Receiver
import com.mynus01.firesns.state.action.OutputAction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val receiver: Receiver
) : CoroutineViewModel() {
    var email = MutableLiveData("")
    var password = MutableLiveData("")
    var viewState = MutableLiveData<ViewState>(ViewState.Init)

    init {
        launch {
            receiver.observe { action ->
                if (action is OutputAction.SignUpOutput) {
                    action.state.collect { state ->
                        viewState.value = state
                    }
                }
            }
        }
    }
}