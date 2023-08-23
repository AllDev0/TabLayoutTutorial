package com.helloworldstudios.tablayouttutorial

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.helloworldstudios.tablayouttutorial.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {
    private lateinit var binding: FragmentSignInBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        sharedPreferences = this.requireActivity().getSharedPreferences("com.helloworldstudios.tablayouttutorial", MODE_PRIVATE)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSignIn.setOnClickListener {
            val user = getInputs(binding)
            if (checkUser(sharedPreferences, user)){
                sharedPreferences.edit().putBoolean("u_login_status", true).apply()
                Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_homeFragment)
            } else{
                Toast.makeText(requireContext(), "Email or password is wrong", Toast.LENGTH_LONG).show()
            }
        }
    }
}