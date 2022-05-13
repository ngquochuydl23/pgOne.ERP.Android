package com.pgone.employee.models

import com.google.gson.annotations.SerializedName

data class AuthenticateDto (
    @SerializedName("userNameOrEmailAddress")
    val userNameOrEmailAddress: String?,
    @SerializedName("password")
    var password: String?,
    @SerializedName("rememberClient")
    val rememberClient: Boolean?
)