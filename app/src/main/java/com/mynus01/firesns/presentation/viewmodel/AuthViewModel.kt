package com.mynus01.firesns.presentation.viewmodel

import androidx.lifecycle.*
import com.mynus01.firesns.domain.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor() : ViewModel() {
    var email = MutableLiveData("")
    var password = MutableLiveData("")
    var viewState = MutableLiveData<ViewState>(ViewState.Init)
}