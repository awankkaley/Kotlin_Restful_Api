package com.awankkaley.springapi.util

import java.util.*

class Utils {
    companion object {
        fun expiredTokenTime(day: Int): Date {
            var dt = Date()
            val c = Calendar.getInstance()
            c.apply {
                time = dt
                add(Calendar.DATE, day)
                dt = this.time
            }
            return dt

        }
    }
}