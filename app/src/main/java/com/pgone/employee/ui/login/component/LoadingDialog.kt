package com.pgone.employee.ui.login.component

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import com.pgone.employee.R
import com.pgone.employee.ui.BaseDialog

class LoadingDialog(val context: Context?) {

  private var dialog: Dialog? = null

  init {
    dialog = Dialog(context!!).apply {
      requestWindowFeature(Window.FEATURE_NO_TITLE)
      setContentView(R.layout.dialog_login_loading)
      window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
      setCancelable(false)
    }
  }

  fun showDialog() {
    dialog?.show()
  }

  fun dismiss() {
    dialog?.dismiss()
  }
}