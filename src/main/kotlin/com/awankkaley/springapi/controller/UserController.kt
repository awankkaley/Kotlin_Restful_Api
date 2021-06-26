package com.awankkaley.springapi.controller

import com.awankkaley.springapi.model.UserRequest
import com.awankkaley.springapi.model.UserResponse
import com.awankkaley.springapi.model.WebResponse
import com.awankkaley.springapi.service.UserService
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.NotBlank

@RestController
class UserController(val userService: UserService) {

    @PostMapping(
        value = ["/api/user"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createUser(@RequestBody body: UserRequest): WebResponse<List<UserResponse>> {
        val userResponse = userService.create(body)
        return WebResponse(data = userResponse)
    }

    @GetMapping(
        value = ["/api/user/{idUser}"],
        produces = ["application/json"]
    )
    fun getUserDetail(@PathVariable("idUser") idUser: Long): WebResponse<UserResponse> {
        val result = userService.get(idUser)
        return WebResponse(data = result)
    }
}