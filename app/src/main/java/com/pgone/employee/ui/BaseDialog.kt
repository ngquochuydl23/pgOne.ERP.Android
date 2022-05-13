package com.pgone.employee.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import androidx.annotation.LayoutRes
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.customview.getCustomView

open class BaseDialog(context: Context?) {

  private var dialog: MaterialDialog? = null
  protected var contentView: View? = null

  init {
    dialog = MaterialDialog(context!!)
    dialog?.cornerRadius(4F)
    onCreateDialog()
  }


  fun setContentView(@LayoutRes layout: Int) {
    dialog?.customView(layout,dialogWrapContent = true,noVerticalPadding = true)
    this.contentView = dialog?.getCustomView()
  }

  fun showDialog() {
    dialog?.show()
  }

  open fun setCanceledOnTouchOutside(isCancel: Boolean) {
    // `isCancel` is true, user cannot touch outside to dismiss the dialog
    dialog?.cancelOnTouchOutside(isCancel)
  }

  open fun onCreateDialog() { }

  open fun dismiss() {
    dialog?.dismiss()
  }
}