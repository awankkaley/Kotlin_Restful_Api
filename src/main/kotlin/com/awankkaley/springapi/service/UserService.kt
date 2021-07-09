package com.awankkaley.springapi.service

import com.awankkaley.springapi.model.*

interface UserService {
    fun create(user: UserRequest): List<UserResponse>
    fun get(id: Long): UserResponse
    fun login(login: LoginRequest): LoginResponse
}