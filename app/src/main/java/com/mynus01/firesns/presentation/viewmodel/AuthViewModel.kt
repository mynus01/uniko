package com.mynus01.firesns.presentation.viewmodel

import androidx.lifecycle.*
import com.mynus01.firesns.presentation.domain.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor() : ViewModel() {
    var email = MutableLiveData("")
    var password = MutableLiveData("")
    var viewState = MutableStateFlow<ViewState>(ViewState.Init)
}