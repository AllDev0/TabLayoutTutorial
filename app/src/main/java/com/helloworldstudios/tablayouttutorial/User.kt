package com.helloworldstudios.tablayouttutorial

data class User(var name: String?, var email: String?, var password: String?){
    constructor(
        email: String?,
        password: String?
    ) : this("", email, password)
}
