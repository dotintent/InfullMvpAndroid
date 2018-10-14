package com.infullmobile.android.infullmvp.sample.activity

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.infullmobile.android.infullmvp.sample.fragment.SampleFragment

class TwoSimplePagesAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val items = listOf("Fragment 1", "Fragment 2")

    override fun getItem(position: Int) = SampleFragment.newInstance(items[position])

    override fun getCount() = items.size

    override fun getPageTitle(position: Int) = items[position]
}