package com.infullmobile.android.infullmvp.sample.activity

import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.widget.Button
import android.widget.TextView
import com.infullmobile.android.infullmvp.PresentedActivityView
import com.infullmobile.android.infullmvp.sample.R

open class SampleActivityView(
        private val pagerAdapter: FragmentStatePagerAdapter
) : PresentedActivityView<SampleActivityPresenter>() {

    val textField: TextView by bindView(R.id.textContainer)
    val pager: ViewPager by bindView(R.id.pagesContainer)
    val showCustomView: Button by bindView(R.id.showCustomView)

    override val layoutResId = R.layout.activity_sample

    override fun onViewsBound() {
        pager.adapter = pagerAdapter
        showCustomView.setOnClickListener { presenter.navigateToCustomView() }
    }

    open var message: String
        get() = textField.text.toString()
        set(value) {
            textField.text = value
        }
}
