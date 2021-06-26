package com.awankkaley.springapi.entity

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "username", unique = true, length = 100)
    val username: String,

    @Column(name = "phone", unique = true, length = 13)
    val phone: String,

    @Column(name = "email", unique = true, length = 90)
    val email: String,

    @Column(name = "password", length = 200)
    val password: String,

    @Column(name = "role")
    val role: String
)