package com.example.taskandroid.taskfragment.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.taskandroid.taskfragment.fragments.Fragment_A
import com.example.taskandroid.taskfragment.fragments.Fragment_B
import com.example.taskandroid.taskfragment.fragments.Fragment_C

class AdapterFragments(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity){
    private val fragList = listOf(Fragment_A(),Fragment_B(),Fragment_C())
    override fun getItemCount(): Int = fragList.size
    override fun createFragment(position: Int): Fragment = fragList[position]
}