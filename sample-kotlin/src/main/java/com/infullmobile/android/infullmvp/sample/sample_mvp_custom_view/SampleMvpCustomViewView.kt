package com.infullmobile.android.infullmvp.sample.sample_mvp_custom_view

import android.widget.TextView
import com.infullmobile.android.infullmvp.PresentedCustomView
import com.infullmobile.android.infullmvp.sample.R

class SampleMvpCustomViewView(
) : PresentedCustomView<SampleMvpCustomViewPresenter>() {

    override val layoutResId = R.layout.custom_view_sample

    val temperature: TextView by bindView(R.id.temperature)
    val temperatureString by bindString(R.string.temperature)

    override fun onViewsBound() {}

    var message: String
        get() = temperature.text.toString()
        set(value) {
            temperature.text = String.format(temperatureString, value)
        }
}