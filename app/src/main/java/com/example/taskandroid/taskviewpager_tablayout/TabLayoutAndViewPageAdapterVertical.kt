package com.example.taskandroid.taskviewpager_tablayout

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabLayoutAndViewPageAdapterVertical (fragmentManager: FragmentManager,lifecycle: Lifecycle,val fragmrnts:List<Fragment>): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = fragmrnts.size

    override fun createFragment(position: Int): Fragment = fragmrnts[position]
}
