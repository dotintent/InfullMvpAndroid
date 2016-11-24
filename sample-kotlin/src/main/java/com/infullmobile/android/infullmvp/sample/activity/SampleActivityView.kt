package com.infullmobile.android.infullmvp.sample.activity

import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.widget.TextView

import com.infullmobile.android.infullmvp.PresentedActivityView
import com.infullmobile.android.infullmvp.sample.R

class SampleActivityView(private val pagerAdapter: FragmentStatePagerAdapter)
    : PresentedActivityView<SampleActivityPresenter>() {

    private val textField: TextView by bindView(R.id.textContainer)
    private val pager: ViewPager by bindView(R.id.pagesContainer)

    override val layoutResId = R.layout.activity_sample

    override fun onViewsBound() {
        pager.adapter = pagerAdapter
    }

    var message: String
        get() = textField.text.toString()
        set(value) {
            textField.text = value
        }
}
