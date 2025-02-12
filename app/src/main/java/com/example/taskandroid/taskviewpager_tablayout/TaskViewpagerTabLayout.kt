package com.example.taskandroid.taskviewpager_tablayout

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.taskandroid.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TaskViewpagerTabLayout : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_viewpager_tab_layout)

        // Find by ID for TabLayout and ViewPager
        tabLayout = findViewById(R.id.tabs)
        viewPager = findViewById(R.id.viewPager)

        // Set adapter for ViewPager
        viewPager.adapter = TabLayoutAndViewPageAdapterHorizontal(this)
        viewPager.setOffscreenPageLimit(2)
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)

                if (viewPager.scrollState==ViewPager2.SCROLL_STATE_DRAGGING && viewPager.currentItem==position && position==0){
                    viewPager.setCurrentItem(2,true)
                }
                else if(viewPager.scrollState==ViewPager2.SCROLL_STATE_DRAGGING && viewPager.currentItem==position && position==2){
                    viewPager.setCurrentItem(0,true)
                }

            }

//            override fun onPageScrollStateChanged(state: Int) {
//                super.onPageScrollStateChanged(state)
//            }
//
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//
//            }
        })

        // Attach TabLayout with ViewPager
        TabLayoutMediator(tabLayout, viewPager) { tab, index ->
            tab.text = when (index) {
                0 -> "Nature"
                1 -> "City"
                2 -> "Universe"
                else -> throw Resources.NotFoundException("Position Not Found")
            }
        }.attach()
    }
}

