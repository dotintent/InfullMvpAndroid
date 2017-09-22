package com.infullmobile.android.infullmvp.sample.fragment

import android.support.annotation.LayoutRes
import android.widget.Button
import android.widget.TextView
import com.infullmobile.android.infullmvp.PresentedFragmentView
import com.infullmobile.android.infullmvp.sample.R

class SampleFragmentView : PresentedFragmentView<SampleFragmentPresenter>() {

    @LayoutRes
    override val layoutResId = R.layout.fragment_sample
    private val fragmentTextViewContainer: TextView by bindView(R.id.fragmentTextContainer)
    private val relaunchButton: Button by bindView(R.id.relaunchButton)

    override fun onViewsBound() {
        relaunchButton.setOnClickListener { presenter.relaunchButtonClicked() }
    }

    fun setText(message: String) {
        fragmentTextViewContainer.text = message
    }
}
