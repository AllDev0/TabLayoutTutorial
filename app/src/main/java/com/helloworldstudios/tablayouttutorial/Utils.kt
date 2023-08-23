package com.helloworldstudios.tablayouttutorial

import android.content.SharedPreferences
import android.util.Log
import com.helloworldstudios.tablayouttutorial.databinding.FragmentSignInBinding
import com.helloworldstudios.tablayouttutorial.databinding.FragmentSignUpBinding

fun getInputs(binding: FragmentSignUpBinding): User{
    return User(
        binding.tietName.text.toString().trim(),
        binding.tietEmail.text.toString().trim(),
        binding.tietPassword.text.toString().trim()
    )
}

fun getInputs(binding: FragmentSignInBinding): User{
    return User(
        binding.tietEmail.text.toString().trim(),
        binding.tietPassword.text.toString().trim()
    )
}

fun saveUser(sharedPreferences: SharedPreferences, user: User){
    sharedPreferences.edit().apply{
        this.putString("u_name", user.name)
        this.putString("u_email", user.email)
        this.putString("u_password", user.password)
        this.putBoolean("u_login_status", true)
    }.apply()
}

fun getUser(sharedPreferences: SharedPreferences): User{
    val email = sharedPreferences.getString("u_email", null)
    val password = sharedPreferences.getString("u_password", null)
    return User(email, password)
}

fun isSignIn(sharedPreferences: SharedPreferences): Boolean = sharedPreferences.getBoolean("u_login_status", false)

fun checkUser(sharedPreferences: SharedPreferences, user: User): Boolean{
    val u_email = sharedPreferences.getString("u_email", null)
    val u_password = sharedPreferences.getString("u_password", null)

    if (u_email != null && u_password != null){
        return if (u_email == user.email && u_password == user.password){
            return true
        } else false
    } else{
        return false
    }

}