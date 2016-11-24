package com.infullmobile.android.infullmvp.sample.activity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

import com.infullmobile.android.infullmvp.sample.fragment.SampleFragment

class TwoPagesAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        return SampleFragment()
    }
}
