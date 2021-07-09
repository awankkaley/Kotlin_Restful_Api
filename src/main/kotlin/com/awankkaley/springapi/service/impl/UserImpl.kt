package com.awankkaley.springapi.service.impl

import com.awankkaley.springapi.model.*
import com.awankkaley.springapi.validation.handler.NotFoundException
import com.awankkaley.springapi.util.DataMapper
import com.awankkaley.springapi.validation.handler.UserAlreadyExistsException
import com.awankkaley.springapi.repository.UserRepository
import com.awankkaley.springapi.service.UserService
import com.awankkaley.springapi.validation.ValidationUtil
import com.awankkaley.springapi.validation.handler.WrongUserPassword
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserImpl(
    val userRepository: UserRepository,
    val validationUtil: ValidationUtil,
    val jwtImpl: JwtImpl
) : UserService {
    override fun create(user: UserRequest): List<UserResponse> {
        validationUtil.validate(user)
        val input = DataMapper.mapRequesttoEntity(user)
        try {
            userRepository.save(input)
            val response = userRepository.findAll()
            return DataMapper.mapEntityToResponse(response)
        } catch (error: Exception) {
            throw UserAlreadyExistsException(error.message)
        }

    }

    override fun get(id: Long): UserResponse {
        val response = userRepository.findByIdOrNull(id)
        if (response == null) {
            throw NotFoundException()
        } else {
            return DataMapper.mapSingleEntityToUserResponse(response)
        }
    }

    override fun login(login: LoginRequest): LoginResponse {
        val response = userRepository.findByUsername(login.username) ?: throw WrongUserPassword()
        if (!BCryptPasswordEncoder().matches(login.password, response.password)) {
            throw WrongUserPassword()
        }
        val issuer = response.id.toString()
        val jwt = jwtImpl.createToken(issuer)
        return DataMapper.mapEntityToLoginResponse(response, jwt.token, jwt.expired)

    }

}