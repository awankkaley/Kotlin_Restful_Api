package com.awankkaley.springapi.service.impl

import com.awankkaley.springapi.DataMapper
import com.awankkaley.springapi.entity.User
import com.awankkaley.springapi.error.NotFoundException
import com.awankkaley.springapi.repository.UserRepository
import com.awankkaley.springapi.model.UserRequest
import com.awankkaley.springapi.model.UserResponse
import com.awankkaley.springapi.service.UserService
import com.awankkaley.springapi.validation.ValidationUtil
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserImpl(val userRepository: UserRepository, val validationUtil: ValidationUtil) : UserService {
    override fun create(user: UserRequest): List<UserResponse> {
        validationUtil.validate(user)
        val input = DataMapper.mapRequesttoEntity(user)
        userRepository.save(input)
        val response = userRepository.findAll()
        return DataMapper.mapEntityToResponse(response)
    }

    override fun get(id: Long): UserResponse {
        val response = userRepository.findByIdOrNull(id)
        if (response == null) {
            throw NotFoundException()
        } else {
            return DataMapper.mapSingleEntityToResponse(response)
        }
    }

}