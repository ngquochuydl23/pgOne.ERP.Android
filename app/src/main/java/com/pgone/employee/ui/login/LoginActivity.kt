package com.pgone.employee.ui.login

import android.os.Bundle
import android.os.Handler
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.pgone.employee.R
import com.pgone.employee.databinding.ActivityLoginBinding
import com.pgone.employee.repositories.Account.AccountRepository
import com.pgone.employee.sharedreferences.SaveTokenSharedPreferences
import com.pgone.employee.ui.BaseActivity
import com.pgone.employee.ui.main.MainActivity

class LoginActivity : BaseActivity() {

  private lateinit var binding: ActivityLoginBinding
  private var loginFailedDialog : LoginFailedDialog? = null
  private var accountRepository : AccountRepository? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
    accountRepository = AccountRepository(this)
    loginFailedDialog = LoginFailedDialog(this)

    binding.isLoading = false
    binding.loginButton.setOnClickListener {
      if (binding.isLoading == false) {

        // When the loading state is loading, disable the button
        binding.isLoading = true


        // This is fake calling api
        accountRepository?.FakeAuthenticate {
          loginSuccessful()
        }
      }
    }

    binding.forgotPasswordButton.setOnClickListener {


    }
  }

  private fun loginSuccessful() {
    binding.isLoading = false
    SaveTokenSharedPreferences(this).setData("")
    navigateTo(MainActivity::class.java)
  }

  private fun loginFailed() {
    loginFailedDialog?.showDialog()
    binding.isLoading = false
  }
}