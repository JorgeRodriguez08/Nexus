package com.example.nexus.common

import com.example.nexus.data.remote.constants.ErrorMessages
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

fun <T> safeApiCall(apiCall: suspend () -> T): Flow<Resource<T>> = flow {
    emit(Resource.Loading)
    try {
        val response = apiCall()
        emit(Resource.Success(response))
    } catch (e: HttpException) {
        emit(Resource.Error(e.localizedMessage ?: ErrorMessages.HTTP))
    } catch (e: IOException) {
        emit(Resource.Error(e.localizedMessage ?: ErrorMessages.NETWORK))
    } catch (e: Exception) {
        emit(Resource.Error(e.localizedMessage ?: ErrorMessages.UNKNOWN))
    }
}