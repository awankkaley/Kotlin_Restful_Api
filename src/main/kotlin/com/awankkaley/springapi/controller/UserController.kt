package com.awankkaley.springapi.controller

import com.awankkaley.springapi.model.*
import com.awankkaley.springapi.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
class UserController(val userService: UserService) {

    @PostMapping(
        value = ["/api/user"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createUser(@RequestBody body: UserRequest): List<UserResponse> {
        return userService.create(body)
    }

    @GetMapping(
        value = ["/api/user/{idUser}"],
        produces = ["application/json"]
    )
    fun getUserDetail(@PathVariable("idUser") idUser: Long): DataResponse<UserResponse> {
        val result = userService.get(idUser)
        return DataResponse(data = result)
    }

    @PostMapping(
        value = ["/api/login"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun login(@RequestBody body: LoginRequest): DataResponse<LoginResponse> {
        val userResponse = userService.login(body)
        return DataResponse(data = userResponse)
    }

}