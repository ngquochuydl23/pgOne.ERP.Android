package com.pgone.employee.utils

import android.content.Context
import com.pgone.employee.sharedreferences.SaveTokenSharedPreferences

fun getBearTokenFromDevicee(context: Context): String {
  return "Bearer " + SaveTokenSharedPreferences(context).getData()
}