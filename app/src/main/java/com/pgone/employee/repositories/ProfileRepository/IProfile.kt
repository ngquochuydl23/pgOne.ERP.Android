package com.pgone.employee.repositories.ProfileRepository

import com.pgone.employee.models.AccountModelDto
import com.pgone.employee.models.ResponseBodyDto
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface IProfile {
  @GET("account/Profile")
  fun GetProfile(
    @Header("Authorization") tokenAuthentication: String,
    @Query("id") id: Int?
  ): Observable<ResponseBodyDto<AccountModelDto>>

  @GET("account/Profile")
  fun GetMyProfile(
    @Header("Authorization") tokenAuthentication: String
  ): Observable<ResponseBodyDto<AccountModelDto>>
}