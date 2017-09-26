package com.infullmobile.android.infullmvp.sample.fragment

import android.net.Uri
import android.os.Bundle
import com.infullmobile.android.infullmvp.Presenter
import com.infullmobile.android.infullmvp.sample.Navigation

class SampleFragmentPresenter(
        presentedView: SampleFragmentView,
        private val sampleFragmentModel: SampleFragmentModel,
        private val navigation: Navigation
) : Presenter<SampleFragmentView>(presentedView) {

    override fun bind(intentBundle: Bundle, savedInstanceState: Bundle, intentData: Uri?) {
        presentedView.setText(sampleFragmentModel.message)
    }

    fun relaunchButtonClicked() = navigation.sampleScreen().start()
}
