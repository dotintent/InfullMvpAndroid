package com.infullmobile.android.infullmvp.sample.sample_mvp_card

import android.net.Uri
import android.os.Bundle
import com.infullmobile.android.infullmvp.Presenter
import com.infullmobile.android.infullmvp.sample.Navigation

open class SampleMvpCardPresenter(
        view: SampleMvpCardView,
        private val model: SampleMvpCardModel,
        private val navigation: Navigation
) : Presenter<SampleMvpCardView>(view) {

    override fun bind(intentBundle: Bundle, savedInstanceState: Bundle, intentData: Uri?) {
        presentedView.displayTemperature(model.getCurrentTemperature())
    }

    fun click() {
        navigation.sampleScreen().start()
    }
}