package com.infullmobile.android.infullmvp.sample.sample_mvp_custom_view

import android.net.Uri
import android.os.Bundle
import com.infullmobile.android.infullmvp.Presenter

class SampleMvpCustomViewPresenter(
        view: SampleMvpCustomViewView,
        private val model: SampleMvpCustomViewModel
) : Presenter<SampleMvpCustomViewView>(view) {

    override fun bind(intentBundle: Bundle, savedInstanceState: Bundle, intentData: Uri?) {
        presentedView.message = model.messageToBeDisplayed
    }

}