package com.pgone.employee.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.pgone.employee.R
import com.pgone.employee.sharedreferences.SaveTokenSharedPreferences
import com.pgone.employee.ui.BaseActivity
import com.pgone.employee.ui.login.LoginActivity

class SplashActivity : BaseActivity() {
  private val DELAY_MILLIS : Long = 2500

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_splash)

    initView()
  }

  private fun initView(){
    setupWindow()
    val handler = Handler()
    handler.postDelayed(delayInMinutes, DELAY_MILLIS)
  }

  private fun setupWindow(){
    window.setFlags(
      WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
      WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
  }

  private val delayInMinutes = Runnable{
    val token = SaveTokenSharedPreferences(this).getData()
    if(token.isNullOrEmpty())
      navigateToWelcome()
    else navigateToMain()
    navigateToMain()
  }

  private fun navigateToMain(){
    val intent = Intent(this, LoginActivity::class.java)
    startActivity(intent)
    finish()
  }

  private fun navigateToWelcome(){
//    val intent = Intent(this, Homescreen::class.java)
//    startActivity(intent)
//    finish()
  }
}