package com.awankkaley.springapi.validation.handler

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ControllerAdviceRequestError : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [(UserAlreadyExistsException::class)])
    fun handleUserAlreadyExists(ex: UserAlreadyExistsException): ResponseEntity<ErrorsDetails> {
        val errorDetails = ErrorsDetails(
            411,
            "failed",
            "Data Already Exist"
        )
        return ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(value = [(NotFoundException::class)])
    fun handleNotFound(ex: NotFoundException): ResponseEntity<ErrorsDetails> {
        val errorDetails = ErrorsDetails(
            412,
            "failed",
            "Data Not Found"
        )
        return ResponseEntity(errorDetails, HttpStatus.OK)
    }

    @ExceptionHandler(value = [(WrongUserPassword::class)])
    fun handleWrongAuth(ex: WrongUserPassword): ResponseEntity<ErrorsDetails> {
        val errorDetails = ErrorsDetails(
            413,
            "failed",
            "Incorrect passowrd"
        )
        return ResponseEntity(errorDetails, HttpStatus.OK)
    }
}

class UserAlreadyExistsException(override val message: String?) : Exception(message)
class NotFoundException : Exception()
class WrongUserPassword : Exception()






