package com.infullmobile.android.infullmvp.sample.temperatureCard

import com.infullmobile.android.infullmvp.MvpView

interface TemperatureCardView : MvpView {
    fun updateText(text: String)
}