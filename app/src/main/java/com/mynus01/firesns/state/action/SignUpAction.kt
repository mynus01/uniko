package com.mynus01.firesns.state.action

import com.mynus01.firesns.state.domain.Action

class SignUpAction(
    val email: String,
    val password: String
) : Action