package com.example.hamlet.utils
/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class ResultResponse<out R> {

    data class Success<out T>(val data: T? = null) : ResultResponse<T>()
    data class Error(val exception: Throwable) : ResultResponse<Nothing>()
    object Loading : ResultResponse<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            is Loading -> "Loading"
        }
    }
}