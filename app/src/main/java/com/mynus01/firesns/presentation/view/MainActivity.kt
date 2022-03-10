package com.mynus01.firesns.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseUser
import com.mynus01.firesns.BR
import com.mynus01.firesns.R
import com.mynus01.firesns.databinding.ActivityMainBinding
import com.mynus01.firesns.presentation.state.ViewState
import com.mynus01.firesns.presentation.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: AuthViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            lifecycleOwner = this@MainActivity
            setVariable(BR.vm, viewModel)
            setVariable(BR.act, this@MainActivity)
        }

        viewModel.viewState.observe(this) { state ->
            when(state) {
                is ViewState.Idle -> {
                    Toast.makeText(this, "Idle", Toast.LENGTH_LONG).show()
                }
                is ViewState.Loading -> {
                    Toast.makeText(this, "Loading", Toast.LENGTH_LONG).show()
                }
                is ViewState.Complete -> {
                    Toast.makeText(this, "Complete", Toast.LENGTH_LONG).show()
                }
                is ViewState.Success<*> -> {
                    Toast.makeText(this, "Success\n ${(state.data as? FirebaseUser)?.email}", Toast.LENGTH_LONG).show()
                }
                is ViewState.Fail -> {
                    Toast.makeText(this, "Fail\n ${state.exception.message}", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}