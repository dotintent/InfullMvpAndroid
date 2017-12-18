package com.infullmobile.android.infullmvp.sample.sample_mvp_card

import android.widget.TextView
import com.infullmobile.android.infullmvp.PresentedCustomView
import com.infullmobile.android.infullmvp.sample.R

open class SampleMvpCardView(
) : PresentedCustomView<SampleMvpCardPresenter>() {

    override val layoutResId = R.layout.custom_view_sample

    val temperatureTextView: TextView by bindView(R.id.temperature)
    val temperatureString by bindString(R.string.temperature)

    override fun onViewsBound() {
        /* NO OP */
    }

    open fun displayTemperature(temperature: Int) {
        temperatureTextView.text = String.format(temperatureString, temperature)
    }
}