package com.infullmobile.android.infullmvp.sample.temperatureCard

import android.view.View
import com.infullmobile.android.infullmvp.PresentedCustomView
import com.infullmobile.android.infullmvp.sample.R
import kotlinx.android.synthetic.main.custom_view_sample.*

class TemperatureCardView(view: View) : PresentedCustomView<TemperatureCardPresenter>(view) {
    override val scopeName = temperatureCardScopeName
    override val layoutId = R.layout.custom_view_sample

    fun updateTemperature(temperatureValue: Int) {
        temperature.text = context.getString(R.string.temperature, temperatureValue)
    }
}