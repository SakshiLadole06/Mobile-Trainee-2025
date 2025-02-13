package com.example.taskandroid.taskviewpager_tablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.taskandroid.R
class UniverseFragment : Fragment() {
    private lateinit var viewPagerUniverseVertical: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_universe, container, false)
        viewPagerUniverseVertical= view.findViewById(R.id.verticalViewPagerUniverse)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val universeImage= listOf(UniverseFragment1(),UniverseFragment2(),UniverseFragment3(),UniverseFragment4(),UniverseFragment5())
        // Set adapter for ViewPager
        viewPagerUniverseVertical.adapter = TabLayoutAndViewPageAdapterVertical(parentFragmentManager,lifecycle,universeImage)

    }
}