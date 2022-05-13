package com.pgone.employee.sharedreferences

import android.content.Context

class SaveTokenSharedPreferences(context: Context?) : BaseSharedPreferences<String?>(context) {

  private val name = "SaveTokenSharedPreferences"

  override fun setName(): String = name

  override fun getData(): String? {
    return sharedPreferences?.getString(name, null)
  }

  override fun setData(data: String?) {
    editor.putString(name, data).commit()
  }

  override fun deleteData() {
    editor.clear().apply()
  }
}