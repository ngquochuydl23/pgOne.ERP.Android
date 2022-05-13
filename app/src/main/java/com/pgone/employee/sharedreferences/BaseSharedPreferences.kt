package com.pgone.employee.sharedreferences

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

abstract class BaseSharedPreferences<T>(val context: Context?) {

  protected val sharedPreferences =
    context?.getSharedPreferences(setName(), Context.MODE_PRIVATE)

  @SuppressLint("CommitPrefEdits")
  protected val editor: SharedPreferences.Editor = sharedPreferences?.edit()!!

  abstract fun setData(data: T)

  abstract fun getData(): T?

  abstract fun deleteData()

  abstract fun setName(): String
}