package com.pgone.employee.ui

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
  open fun navigateTo(activity: Class<*>) {
    val intent = Intent(this, activity)
    startActivity(intent)
  }
}