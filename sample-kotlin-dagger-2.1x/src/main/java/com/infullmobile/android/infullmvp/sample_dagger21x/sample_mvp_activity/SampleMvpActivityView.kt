package com.infullmobile.android.infullmvp.sample_dagger21x.sample_mvp_activity

import android.support.annotation.LayoutRes
import android.widget.TextView
import com.infullmobile.android.infullmvp.PresentedActivityView
import com.infullmobile.android.infullmvp.sample_dagger21x.R

import javax.inject.Inject

class SampleMvpActivityView @Inject constructor(
) : PresentedActivityView<SampleMvpActivityPresenter>() {

    @LayoutRes override val layoutResId = R.layout.activity_mvp
    val textDisplay: TextView by bindView(R.id.textDisplay)

    override fun onViewsBound() {
        /* empty */
    }

    var displayedText: String
        get() = textDisplay.text.toString()
        set(value) {
            textDisplay.text = value
        }
}
