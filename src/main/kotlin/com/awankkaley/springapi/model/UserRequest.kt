package com.awankkaley.springapi.model

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

class UserRequest(
    @field:NotBlank
    @field:Length(min = 6, max = 100)
    val username: String,

    @field:NotBlank
    val phone: String,

    @field:NotBlank
    @field:Length(min = 6, max = 90)
    @field:Email
    val email: String,

    @field:NotBlank
    @field:Length(min = 8, max = 90)
    val password: String
)