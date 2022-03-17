package com.mynus01.firesns.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseUser
import com.mynus01.firesns.BR
import com.mynus01.firesns.R
import com.mynus01.firesns.datasource.interactor.FirebaseAuthInteractor
import com.mynus01.firesns.databinding.ActivityMainBinding
import com.mynus01.firesns.domain.ViewState
import com.mynus01.firesns.presentation.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var interactor: FirebaseAuthInteractor
    private val viewModel: AuthViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            lifecycleOwner = this@MainActivity
            setVariable(BR.vm, viewModel)
        }

        viewModel.viewState.observe(this) { state ->
            when (state) {
                is ViewState.Init -> {
                    Toast.makeText(this, "Init", Toast.LENGTH_SHORT).show()
                }
                is ViewState.Loading -> {
                    Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()
                }
                is ViewState.Complete -> {
                    when (state) {
                        is ViewState.Complete.Empty -> {
                            Toast.makeText(this, "Empty response", Toast.LENGTH_SHORT).show()
                        }
                        is ViewState.Complete.Success<*> -> {
                            Toast.makeText(this, "Success\n ${(state.data as? FirebaseUser)?.email}", Toast.LENGTH_SHORT).show()
                        }
                        is ViewState.Complete.Fail -> {
                            Toast.makeText(this, "Fail\n ${state.exception.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }

    fun signUp(v: View) {
        CoroutineScope(Dispatchers.Default).launch {
            interactor.signUp(viewModel.email.value!!, viewModel.password.value!!).collect { state ->
                viewModel.viewState.postValue(state)
            }
        }
    }
}