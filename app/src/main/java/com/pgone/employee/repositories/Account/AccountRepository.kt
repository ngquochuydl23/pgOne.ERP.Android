package com.pgone.employee.repositories.Account

import android.content.Context
import android.os.Handler
import com.pgone.employee.models.RequestLoginDto
import com.pgone.employee.models.ResponseAccountDto
import com.pgone.employee.models.ResponseBodyDto
import com.pgone.employee.repositories.IHttpClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class AccountRepository(val context: Context) : IHttpClient {

  var service: IAccount

  init {
    service = retrofit.create(IAccount::class.java)
  }

  fun Login(request: RequestLoginDto): Observable<ResponseBodyDto<ResponseAccountDto>> {

    return service.Login(request)
      .observeOn(AndroidSchedulers.mainThread())
      .subscribeOn(Schedulers.io())
  }
}