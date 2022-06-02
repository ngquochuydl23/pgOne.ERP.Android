package com.pgone.employee.models

import com.google.gson.annotations.SerializedName

data class RequestLoginDto(
  @SerializedName("username")
  val username: String,
  @SerializedName("password")
  val password: String
)