package com.pgone.employee.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseAccountDto {
  @SerializedName("account")
  @Expose
  var account: AccountModelDto? = null

  @SerializedName("token")
  @Expose
  var token: String? = null
}