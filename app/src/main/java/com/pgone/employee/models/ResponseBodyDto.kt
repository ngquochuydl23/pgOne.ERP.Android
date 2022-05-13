package com.pgone.employee.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseBodyDto<T> {
    @SerializedName("result")
    @Expose
    val result: T? = null

    @SerializedName("error")
    @Expose
    val error: ErrorDto? = null

    @SerializedName("targetUrl")
    @Expose
    val targetUrl: String? = null

    @SerializedName("success")
    @Expose
    val success: Boolean = false

    @SerializedName("unAuthorizedRequest")
    @Expose
    val unAuthorizedRequest: Boolean? = null
}
