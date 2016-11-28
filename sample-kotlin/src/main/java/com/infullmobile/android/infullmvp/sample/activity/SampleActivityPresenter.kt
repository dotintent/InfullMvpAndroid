package com.infullmobile.android.infullmvp.sample.activity

import android.os.Bundle
import com.infullmobile.android.infullmvp.Presenter

class SampleActivityPresenter(presentedView: SampleActivityView,
                              private val sampleActivityModel: SampleActivityModel)
    : Presenter<SampleActivityView>(presentedView) {

    override fun bind(intentBundle: Bundle) {
        presentedView.message = sampleActivityModel.message
    }
}