package com.pgone.employee.repositories.Account

import com.pgone.employee.models.AuthenticateDto
import com.pgone.employee.models.AuthenticateResponseDto
import com.pgone.employee.models.ResponseBodyDto
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface IAccount {
    @POST("services/app/Account/Register")
    fun Authenticate(@Body authDataInput: AuthenticateDto?): Observable<ResponseBodyDto<AuthenticateResponseDto>>
}