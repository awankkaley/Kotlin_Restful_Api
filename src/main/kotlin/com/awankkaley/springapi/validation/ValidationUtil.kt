package com.awankkaley.springapi.validation

import org.springframework.stereotype.Component
import javax.validation.ConstraintViolationException
import javax.validation.Validator

@Component
class ValidationUtil(private val validator: Validator) {
    fun validate(any: Any) {
        val result = validator.validate(any)
        if (result.size != 0) {
            throw  ConstraintViolationException(result)
        }
    }
}