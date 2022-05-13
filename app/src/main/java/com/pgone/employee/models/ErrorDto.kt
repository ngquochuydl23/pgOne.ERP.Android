package com.pgone.employee.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ErrorDto {
    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("details")
    @Expose
    var details: String? = null
}