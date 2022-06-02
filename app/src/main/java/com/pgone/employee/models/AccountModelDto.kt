package com.pgone.employee.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AccountModelDto {
  @SerializedName("id")
  @Expose
  var id: Int? = null

  @SerializedName("userName")
  @Expose
  var userName: String? = null

  @SerializedName("avatar")
  @Expose
  var avatar: String? = null

  @SerializedName("bio")
  @Expose
  var bio: String? = null

  @SerializedName("cover")
  @Expose
  var cover: String? = null

  @SerializedName("birthday")
  @Expose
  var birthday: String? = null

  @SerializedName("phoneNumber")
  @Expose
  var phoneNumber: String? = null

  @SerializedName("email")
  @Expose
  var email: String? = null
}