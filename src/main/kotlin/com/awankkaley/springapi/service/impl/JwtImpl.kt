package com.awankkaley.springapi.service.impl

import com.awankkaley.springapi.config.JwtConfiguration
import com.awankkaley.springapi.model.JwtResponse
import com.awankkaley.springapi.service.JwtService
import com.awankkaley.springapi.util.Utils
import com.awankkaley.springapi.util.dateToString
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class JwtImpl : JwtService {
    @Autowired
    lateinit var jwtConfiguration: JwtConfiguration

    override fun createToken(issuer: String): JwtResponse {

        val expired = Utils.expiredTokenTime(jwtConfiguration.dayConfig.toInt())
        val jwt = Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(expired)
            .signWith(
                Keys.hmacShaKeyFor(jwtConfiguration.key.toByteArray()),
                SignatureAlgorithm.HS256
            ).compact()

        return JwtResponse(jwt, expired.dateToString())
    }

    override fun blacklistToken() {
        val jwt = Jwts.parser()
            .setSigningKey(
                jwtConfiguration.key.toByteArray()
            )

    }
}