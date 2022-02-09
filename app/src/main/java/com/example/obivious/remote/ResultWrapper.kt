package com.example.obivious.remote

sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T) : ResultWrapper<T>()
    data class Error(val error: Throwable?) : ResultWrapper<Nothing>()
}