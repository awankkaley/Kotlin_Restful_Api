package com.awankkaley.springapi.config

import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

import org.springframework.security.crypto.password.PasswordEncoder


@Bean
fun passwordEncoder(): PasswordEncoder {
    return BCryptPasswordEncoder()
}