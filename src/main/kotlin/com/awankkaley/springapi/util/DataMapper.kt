package com.awankkaley.springapi.util

import com.awankkaley.springapi.entity.User
import com.awankkaley.springapi.model.LoginResponse
import com.awankkaley.springapi.model.UserRequest
import com.awankkaley.springapi.model.UserResponse
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import kotlin.collections.ArrayList

object DataMapper {
    fun mapRequesttoEntity(input: UserRequest): User {
        return User(
            username = input.username,
            email = input.email,
            phone = input.phone,
            password = BCryptPasswordEncoder().encode(input.password),
            role = "user"
        )
    }

    fun mapEntityToResponse(input: List<User>): List<UserResponse> {
        val result = ArrayList<UserResponse>()
        input.map {
            val response = UserResponse(
                id = it.id,
                username = it.username,
                email = it.email,
                phone = it.phone
            )
            result.add(response)
        }
        return result
    }

    fun mapSingleEntityToUserResponse(input: User): UserResponse {
        return UserResponse(
            id = input.id,
            username = input.username,
            email = input.email,
            phone = input.phone,
        )
    }

    fun mapEntityToLoginResponse(input: User, token: String, expired: String): LoginResponse {
        return LoginResponse(
            id = input.id,
            username = input.username,
            email = input.email,
            phone = input.phone,
            token = token,
            expired_at = expired
        )
    }


}