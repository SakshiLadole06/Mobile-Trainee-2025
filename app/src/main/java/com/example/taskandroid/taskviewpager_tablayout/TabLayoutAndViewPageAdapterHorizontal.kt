package com.example.taskandroid.taskviewpager_tablayout

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabLayoutAndViewPageAdapterHorizontal(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) { // its ok
//class TabLayoutAndViewPageAdapterHorizontal(fragmentManager: FragmentManager, lifecycle: Lifecycle, ) : FragmentStateAdapter(fragmentManager, lifecycle) {  //but better way use this

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {NatureFragment()}
            1 -> {CityFragment()}
            2 -> {UniverseFragment()}
            else->{throw Resources.NotFoundException("Position Not Found")}
        }
    }
}

