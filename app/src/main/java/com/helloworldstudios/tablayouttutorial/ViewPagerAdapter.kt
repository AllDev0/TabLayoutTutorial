package com.helloworldstudios.tablayouttutorial

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabItem

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {
                SignInFragment()
            }

            1 -> {
                SignUpFragment()
            }

            else -> {
                SignInFragment()
            }
        }
    }
}