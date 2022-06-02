package com.pgone.employee.repositories.Account

import com.pgone.employee.models.RequestLoginDto
import com.pgone.employee.models.ResponseBodyDto
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.*
import com.pgone.employee.models.ResponseAccountDto
interface IAccount {
    @POST("account/Login")
    fun Login(@Body request: RequestLoginDto): Observable<ResponseBodyDto<ResponseAccountDto>>
}