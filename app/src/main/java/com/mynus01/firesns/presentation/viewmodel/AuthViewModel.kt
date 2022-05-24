package com.mynus01.firesns.presentation.viewmodel

import androidx.lifecycle.*
import com.mynus01.firesns.domain.ViewState
import com.mynus01.uniko.receiver.Receiver
import com.mynus01.firesns.presentation.uniko.action.OutAction
import com.mynus01.uniko.extension.launch
import com.mynus01.uniko.extension.observe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    receiver: Receiver
) : ViewModel() {
    var email = MutableLiveData("")
    var password = MutableLiveData("")
    var viewStateLiveData = MutableLiveData<ViewState>(ViewState.Init)

    init {
        receiver.observe(OutAction.SignUpOutput::class) { action ->
            launch {
                action.viewState.collect { state ->
                    viewStateLiveData.value = state
                }
            }
        }
    }
}