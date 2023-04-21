package com.example.midascategory


import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.midascategory.adapter.ViewPagerImageAdapter
import com.example.midascategory.adapter.ViewPagerTabAdapter
import com.example.midascategory.databinding.ActivityMainBinding
import com.example.midascategory.repositotry.MainActivityRepository.serviceSetterGetter
import com.example.viewmodel.MainActivityViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var mainActivityBinding: ActivityMainBinding

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        mainActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        mainActivityViewModel.userProduct()?.observe(this) { userData ->

            mainActivityBinding.model = userData


            val adapter = ViewPagerImageAdapter(userData.response_data!!.image_gallery)
            mainActivityBinding.viewPagerImage.adapter = adapter
            mainActivityBinding.viewPagerImage.clipToPadding = false
            mainActivityBinding.viewPagerImage.clipChildren = false
            mainActivityBinding.viewPagerImage.offscreenPageLimit = 2
            TabLayoutMediator(mainActivityBinding.tabs, mainActivityBinding.viewPagerImage)
            { _, _ -> }.attach()


            val tabadapter = ViewPagerTabAdapter(userData.response_data!!.product_data)
            mainActivityBinding.viewPagerTab.adapter = tabadapter
            mainActivityBinding.viewPagerTab.clipToPadding = false
            mainActivityBinding.viewPagerTab.clipChildren = false
            mainActivityBinding.viewPagerTab.offscreenPageLimit = 2


            /*   TabLayoutMediator(
                   mainActivityBinding.tabTitleLayout,
                   mainActivityBinding.viewPagerTab
               )
               { _, _ -> }.attach()*/
            for (i in 0 until userData.response_data?.product_data?.size!!) {
                mainActivityBinding.tabTitleLayout.newTab()
                    .setText("${userData.response_data!!.product_data[i].title}").let {
                        mainActivityBinding.tabTitleLayout.addTab(
                            it
                        )
                    }
            }

        }

        mainActivityBinding.tabTitleLayout.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                mainActivityBinding.viewPagerTab.currentItem = tab?.position!!
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        mainActivityBinding.viewPagerTab.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                mainActivityBinding.tabTitleLayout.getTabAt(position)?.select()
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }
        })


    }





}