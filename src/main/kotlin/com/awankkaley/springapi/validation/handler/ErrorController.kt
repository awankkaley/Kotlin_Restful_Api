package com.awankkaley.springapi.validation.handler

import com.awankkaley.springapi.model.DataResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ErrorController {
    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException): DataResponse<String> {
        return DataResponse(code = 400, status = "BAD REQUEST", data = constraintViolationException.message.toString())
    }
}