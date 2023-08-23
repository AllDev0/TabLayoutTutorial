package com.helloworldstudios.tablayouttutorial

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.google.android.material.tabs.TabLayout
import com.helloworldstudios.tablayouttutorial.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.toolbar.title = "Home Fragment"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        sharedPreferences = this.requireActivity()
            .getSharedPreferences("com.helloworldstudios.tablayouttutorial", MODE_PRIVATE)
        val name = sharedPreferences.getString("u_name", null)
        Toast.makeText(requireContext(), "Welcome $name", Toast.LENGTH_LONG).show()
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_logout -> {
                sharedPreferences.edit().putBoolean("u_login_status", false).apply()
                Navigation.findNavController(requireView()).navigate(R.id.action_homeFragment_to_loginFragment)
                return true
            }

            R.id.action_deleteAccount -> {
                sharedPreferences.edit().apply {
                    this.remove("u_name")
                    this.remove("u_email")
                    this.remove("u_password")
                    this.remove("u_login_status")
                }.apply()
                Navigation.findNavController(requireView()).navigate(R.id.action_homeFragment_to_loginFragment)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}