package com.mynus01.firesns.presentation.viewmodel

import android.app.Activity
import androidx.lifecycle.*
import com.mynus01.firesns.data.interactor.FirebaseAuthInteractor
import com.mynus01.firesns.data.interactor.FirebaseAuthInteractorOutput
import com.mynus01.firesns.data.interactor.InteractorState
import com.mynus01.firesns.presentation.state.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val interactor: FirebaseAuthInteractor
) : ViewModel(), FirebaseAuthInteractorOutput {
    var viewState = MutableLiveData<ViewState>(ViewState.Init)
    var email = MutableLiveData("")
    var password = MutableLiveData("")

    fun signUp(activity: Activity) {
        CoroutineScope(Dispatchers.IO).launch {
            interactor.signUp(activity.mainExecutor, email.value!!, password.value!!, this@AuthViewModel)
        }
    }

    override fun collectInteractorState(state: InteractorState) {
        viewState.postValue(state.toViewState())
    }
}

fun InteractorState.toViewState(): ViewState {
    return when (this) {
        is InteractorState.Idle -> ViewState.Init
        is InteractorState.Loading -> ViewState.Loading
        is InteractorState.Complete -> {
            when(this) {
                is InteractorState.Complete.Empty -> ViewState.Complete.Empty
                is InteractorState.Complete.Success<*> -> ViewState.Complete.Success(this.data)
                is InteractorState.Complete.Fail -> ViewState.Complete.Fail(this.exception)
            }
        }
    }
}