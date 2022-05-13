package com.pgone.employee.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pgone.employee.R
import com.pgone.employee.ui.BaseActivity

class MainActivity : BaseActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }
}