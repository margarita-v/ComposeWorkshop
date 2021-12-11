package com.example.composeworkshop.core.request

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

fun <T> requestFlow(requestFunc: suspend () -> T): Flow<Request<T>> {
    return flow<Request<T>> {
        emit(Request.Success(requestFunc()))
    }.onStart {
        emit(Request.Loading())
    }.catch { error ->
        emit(Request.Error(error))
    }
}