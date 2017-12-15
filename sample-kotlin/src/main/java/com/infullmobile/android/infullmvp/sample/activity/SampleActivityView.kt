package com.infullmobile.android.infullmvp.sample.activity

import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.widget.TextView

import com.infullmobile.android.infullmvp.PresentedActivityView
import com.infullmobile.android.infullmvp.sample.R
import com.infullmobile.android.infullmvp.sample.sample_mvp_custom_view.SampleMvpCustomView

open class SampleActivityView(
        private val pagerAdapter: FragmentStatePagerAdapter
) : PresentedActivityView<SampleActivityPresenter>() {

    val textField: TextView by bindView(R.id.textContainer)
    val pager: ViewPager by bindView(R.id.pagesContainer)
    val customView: SampleMvpCustomView by bindView(R.id.customView)

    override val layoutResId = R.layout.activity_sample

    override fun onViewsBound() {
        pager.adapter = pagerAdapter
    }

    open var message: String
        get() = textField.text.toString()
        set(value) {
            textField.text = value
        }
}
