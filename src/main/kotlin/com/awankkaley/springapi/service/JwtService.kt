package com.awankkaley.springapi.service

import com.awankkaley.springapi.model.JwtResponse

interface JwtService {
    fun createToken(issuer: String): JwtResponse
    fun blacklistToken()
}