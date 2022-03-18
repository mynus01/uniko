package com.mynus01.firesns.presentation.viewmodel

import androidx.lifecycle.*
import com.mynus01.firesns.domain.ViewState
import com.mynus01.firesns.state.action.OutputAction
import com.mynus01.firesns.state.receive
import com.mynus01.firesns.state.store.AppStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor() : CoroutineViewModel() {
    var email = MutableLiveData("")
    var password = MutableLiveData("")
    var viewState = MutableLiveData<ViewState>(ViewState.Init)

    init {
        launch {
            receive { action ->
                if (action is OutputAction.SignUpOutput) {
                    action.state.collect { state ->
                        viewState.value = state
                    }
                }
            }
        }
    }
}