package com.pgone.employee.ui.login

import android.content.Context
import com.pgone.employee.R
import com.pgone.employee.ui.BaseDialog

class LoginFailedDialog(context: Context?) : BaseDialog(context) {
  override fun onCreateDialog() {
    super.onCreateDialog()
    setContentView(R.layout.dialog_login_failed)
    setCanceledOnTouchOutside(false)
  }
}