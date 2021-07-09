package com.awankkaley.springapi.util


fun logIt(clazz: String, message: String, data: String, code: Int = 0) {
    print("------------START LOGGING---------\n")
    print("message : $message \n")
    print("code : $code\n")
    print("data : $data\n")
    print("------------END LOGGING---------\n")
}