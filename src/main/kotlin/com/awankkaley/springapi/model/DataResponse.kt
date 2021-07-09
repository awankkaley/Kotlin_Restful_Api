package com.awankkaley.springapi.model

data class DataResponse<T>(
    val code: Int = 200,
    val status: String = "success",
    val data: T
)