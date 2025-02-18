package com.example.taskandroid.taskviewpager_tablayout

import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.taskandroid.R
import com.google.android.material.tabs.TabLayoutMediator

class NatureFragment : Fragment() {
    private lateinit var viewPagerNatureVertical: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_nature, container, false)

        viewPagerNatureVertical = view.findViewById(R.id.verticalViewPagerNature)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val natureImage= listOf(NatureFragment1(),NatureFragment2(),NatureFragment3(),NatureFragment4(),NatureFragment5())
        // Set adapter for ViewPager
        viewPagerNatureVertical.adapter = TabLayoutAndViewPageAdapterVertical(parentFragmentManager,lifecycle,natureImage)

    }
}
