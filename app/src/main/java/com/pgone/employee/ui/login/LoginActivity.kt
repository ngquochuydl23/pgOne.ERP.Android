package com.pgone.employee.ui.login

import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.pgone.employee.R
import com.pgone.employee.component.AccountInputField
import com.pgone.employee.databinding.ActivityLoginBinding
import com.pgone.employee.models.RequestLoginDto
import com.pgone.employee.models.ResponseAccountDto
import com.pgone.employee.models.ResponseBodyDto
import com.pgone.employee.repositories.Account.AccountRepository
import com.pgone.employee.sharedreferences.SaveTokenSharedPreferences
import com.pgone.employee.ui.BaseActivity
import com.pgone.employee.ui.login.component.LoadingDialog
import com.pgone.employee.ui.login.component.LoginFailedDialog
import com.pgone.employee.ui.main.MainActivity
import com.pgone.employee.utils.ErrorUtils
import com.pgone.employee.utils.hideKeyboard
import com.pgone.employee.utils.validateEmail
import com.pgone.employee.utils.validatePassword
import io.reactivex.rxjava3.functions.Consumer

class LoginActivity : BaseActivity() {

  private lateinit var binding: ActivityLoginBinding
  private var loginFailedDialog: LoginFailedDialog? = null
  private var loadingDialog: LoadingDialog? = null
  private var accountRepository: AccountRepository? = null


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
    accountRepository = AccountRepository(this)
    loginFailedDialog = LoginFailedDialog(this)
    loadingDialog = LoadingDialog(this)

    binding.loginButton.setOnClickListener {
      login(it)
    }

    setupEnterPasswordEvent()
    binding.forgotPasswordButton.setOnClickListener {

    }
  }

  private fun login(it: View) {
    val errorEmail = validateEmail(binding.enterEmail.getTextField())
    val errorPassword = validatePassword(binding.enterPassword.getTextField())

    if (!errorEmail.isNullOrEmpty() || !errorPassword.isNullOrEmpty()) {
      binding.enterEmail.setErrorText(errorEmail)
      binding.enterPassword.setErrorText(errorPassword)
      return
    }

    loadingDialog?.showDialog()
    binding.enterEmail.clearFocusField()
    binding.enterPassword.clearFocusField()
    hideKeyboard(this, it)

    val email = binding.enterEmail.getTextField()
    val password = binding.enterPassword.getTextField()

    accountRepository
      ?.Login(RequestLoginDto(email, password))
      ?.subscribe(loginSuccessful, loginFailed)
  }

  private val loginSuccessful: Consumer<in ResponseBodyDto<ResponseAccountDto>>
    get() = Consumer {
      loadingDialog?.dismiss()

      val account = it.result?.account
      val token = it.result?.token

      Toast.makeText(this, "Hello ${account?.userName}", Toast.LENGTH_SHORT).show()
//      SaveTokenSharedPreferences(this).setData("")
//      navigateTo(MainActivity::class.java)
    }


  private val loginFailed: Consumer<in Throwable>
    get() = Consumer {
      loadingDialog?.dismiss()

      val errorUtils = ErrorUtils<ResponseAccountDto>()
      val errorBody = errorUtils.parseErrorBody(accountRepository?.retrofit, it)

      loginFailedDialog?.showDialog()
    }

  private fun setupEnterPasswordEvent() {
    binding.enterPassword.setAccountInputFieldEvent(object : AccountInputField.Event {
      override fun onToggleRightIcon(toggle: Boolean) {
        if (toggle) {
          binding.enterPassword.setInputType(InputType.TYPE_CLASS_TEXT)
          return
        }
        binding.enterPassword.setInputType(0x00000081)
      }
    })
  }
}