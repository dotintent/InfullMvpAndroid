package com.infullmobile.android.infullmvp.sample_dagger21x.sample_mvp_activity

import android.net.Uri
import android.os.Bundle
import com.infullmobile.android.infullmvp.Presenter
import javax.inject.Inject

class SampleMvpActivityPresenter @Inject constructor(
        private val model: SampleMvpActivityModel,
        view: SampleMvpActivityView
) : Presenter<SampleMvpActivityView>(view) {

    override fun bind(intentBundle: Bundle, savedInstanceState: Bundle, intentData: Uri?) {
        presentedView.displayedText = model.messageToBeDisplayed
    }
}
