package com.pgone.employee.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

fun hideKeyboard(activity : Activity, view: View){
  val inputMethod = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
  inputMethod.hideSoftInputFromWindow(view.applicationWindowToken, 0)
}