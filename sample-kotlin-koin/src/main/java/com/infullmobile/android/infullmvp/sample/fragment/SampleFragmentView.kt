package com.infullmobile.android.infullmvp.sample.fragment

import android.support.v4.app.Fragment
import com.infullmobile.android.infullmvp.PresentedFragmentView
import com.infullmobile.android.infullmvp.sample.R
import kotlinx.android.synthetic.main.fragment_sample.*

class SampleFragmentView(fragment: Fragment) : PresentedFragmentView<SampleFragmentPresenter>(fragment) {
    override val scopeName = sampleFragmentScopeName
    override val layoutId = R.layout.fragment_sample

    fun updateText(text: String) {
        fragmentTextContainer.text = text
    }
}