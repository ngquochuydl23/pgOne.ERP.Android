package com.pgone.employee.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AuthenticateResponseDto {
    @SerializedName("accessToken")
    @Expose
    var accessToken: String? = null

    @SerializedName("encryptedAccessToken")
    @Expose
    var encryptedAccessToken: String? = null

    @SerializedName("expireInSeconds")
    @Expose
    var expireInSeconds: Int? = null

    @SerializedName("userId")
    @Expose
    var userId: Int? = null
}