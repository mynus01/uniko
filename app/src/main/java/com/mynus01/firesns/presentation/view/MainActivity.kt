package com.mynus01.firesns.presentation.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mynus01.firesns.BR
import com.mynus01.firesns.R
import com.mynus01.firesns.databinding.ActivityMainBinding
import com.mynus01.firesns.datasource.interactor.AuthInteractor
import com.mynus01.firesns.domain.ViewState
import com.mynus01.firesns.presentation.uniko.action.input.SignUpInput
import com.mynus01.firesns.presentation.viewmodel.AuthViewModel
import com.mynus01.uniko.action.InputAction
import com.mynus01.uniko.dispatcher.Dispatcher
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: AuthViewModel by viewModels()
    @Inject
    lateinit var interactor: AuthInteractor
    @Inject
    lateinit var dispatcher: Dispatcher<InputAction>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            lifecycleOwner = this@MainActivity
            setVariable(BR.vm, viewModel)
        }

        viewModel.viewStateLiveData.observe(this) { state ->
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
                            Toast.makeText(this, "Success\n${state.data}", Toast.LENGTH_SHORT).show()
                        }
                        is ViewState.Complete.Fail -> {
                            Toast.makeText(this, "Fail\n${state.exception.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }

    fun signUp(v: View) {
        val email = viewModel.email.value
        val password = viewModel.password.value

        if (email != null && password != null) {
            dispatcher.dispatch(SignUpInput(interactor, email, password))
        }
    }
}