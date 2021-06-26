package com.awankkaley.springapi.service
import com.awankkaley.springapi.model.UserRequest
import com.awankkaley.springapi.model.UserResponse

interface UserService {
    fun create(user: UserRequest): List<UserResponse>
    fun get(id : Long): UserResponse

}