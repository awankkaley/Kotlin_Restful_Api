package com.awankkaley.springapi.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class JwtConfiguration {
    @Value("\${jwt.secret}")
    lateinit var key: String

    @Value("\${jwt.tokenExpirationAfterDays}")
    lateinit var dayConfig: String
}