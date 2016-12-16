package com.infullmobile.android.infullmvp.sample.fragment

import android.os.Bundle

import com.infullmobile.android.infullmvp.Presenter

class SampleFragmentPresenter(presentedView: SampleFragmentView,
                              private val sampleFragmentModel: SampleFragmentModel)
    : Presenter<SampleFragmentView>(presentedView) {

    override fun bind(intentBundle: Bundle, savedInstanceState: Bundle) {
        presentedView.setText(sampleFragmentModel.message)
    }
}
