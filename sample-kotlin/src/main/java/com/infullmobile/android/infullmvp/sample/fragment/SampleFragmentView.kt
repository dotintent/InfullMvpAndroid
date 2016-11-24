package com.infullmobile.android.infullmvp.sample.fragment

import android.support.annotation.LayoutRes
import android.widget.TextView
import com.infullmobile.android.infullmvp.PresentedFragmentView
import com.infullmobile.android.infullmvp.sample.R

class SampleFragmentView : PresentedFragmentView<SampleFragmentPresenter>() {

    @LayoutRes
    override val layoutResId = R.layout.fragment_sample
    private val fragmentTextViewContainer: TextView by bindView(R.id.fragmentTextContainer)

    override fun onViewsBound() {
        // NO OP
    }

    fun setText(message: String) {
        fragmentTextViewContainer.text = message
    }
}
