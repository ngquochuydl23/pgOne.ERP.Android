package com.pgone.employee.utils

import android.util.Log
import com.pgone.employee.models.ErrorDto
import com.pgone.employee.models.ResponseBodyDto
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.HttpException
import retrofit2.Retrofit
import java.io.IOException

class ErrorUtils<T> {

  fun parseErrorBody(retrofit : Retrofit?, throwable : Throwable) : ErrorDto? {

    if(retrofit == null){
      return null
    }

    if(throwable is HttpException){
      val body = (throwable as HttpException).response()?.errorBody()

      val errorConverter: Converter<ResponseBody, ResponseBodyDto<T>> =
        retrofit.responseBodyConverter(ResponseBodyDto<T>()::class.java, arrayOfNulls<Annotation>(0))

      try {
        val errorBody: ResponseBodyDto<T>? = errorConverter.convert(body)
        return errorBody?.error

      } catch (exception: IOException) {
        exception.printStackTrace()
      }
    }
    return null
  }

  fun parseError(retrofit : Retrofit? ,throwable : Throwable) : String? {
    val errorBody = parseErrorBody(retrofit, throwable)
    Log.i("ERROR", "ERROR: " + errorBody?.message)
    return errorBody?.message
  }
}