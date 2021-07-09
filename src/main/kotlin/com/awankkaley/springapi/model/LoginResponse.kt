package com.awankkaley.springapi.model

data class LoginResponse(
    val id: Long,
    val username: String,
    val phone: String,
    val email: String,
    val token: String,
    val expired_at: String
)
