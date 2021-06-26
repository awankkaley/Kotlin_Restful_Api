package com.awankkaley.springapi

import com.awankkaley.springapi.entity.User
import com.awankkaley.springapi.model.UserRequest
import com.awankkaley.springapi.model.UserResponse

object DataMapper {
    fun mapRequesttoEntity(input: UserRequest): User {
        return User(
            username = input.username,
            email = input.email,
            phone = input.phone,
            password = input.password,
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

    fun mapSingleEntityToResponse(input: User): UserResponse {
        return UserResponse(
            id = input.id,
            username = input.username,
            email = input.email,
            phone = input.phone,
        )
    }
}