package com.pgone.employee.utils

import java.util.regex.Pattern

fun validateEmail(email: String): String? {
  if (email.isEmpty())
    return "Please enter your email!"
  return null
}

fun validatePassword(password: String): String? {
  if (password.isEmpty())
    return "Please enter your password!"

  val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=\\S+$).{4,}$"
  val pattern = Pattern.compile(PASSWORD_PATTERN);
  val matcher = pattern.matcher(password)

  if (!matcher.matches())
    return "Password must have an upper charater, number!"
  return null
}