package com.it.thoson.mvvmtutorial.view

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.it.thoson.mvvmtutorial.MyApplication
import com.it.thoson.mvvmtutorial.R
import com.it.thoson.mvvmtutorial.databinding.ActivityLoginBinding
import com.it.thoson.mvvmtutorial.viewmodel.LoginViewModel
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    @Inject lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login)
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        (application as MyApplication).diComponent.inject(this)

        binding.loginViewModel = loginViewModel
    }
}
