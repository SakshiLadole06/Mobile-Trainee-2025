package com.example.taskandroid.taskviewpager_tablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.taskandroid.R

class CityFragment : Fragment() {
    private lateinit var viewPagerCityVertical: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_city, container, false)
        viewPagerCityVertical= view.findViewById(R.id.verticalViewPagerCity)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cityImage= listOf(CityFragment1(),CityFragment2(),CityFragment3(),CityFragment4(),CityFragment5())
        // Set adapter for ViewPager
        viewPagerCityVertical.adapter = TabLayoutAndViewPageAdapterVertical(parentFragmentManager,lifecycle,cityImage)

    }
}