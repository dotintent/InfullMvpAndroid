package com.infullmobile.android.infullmvp.sample.temperatureCard

import android.os.Bundle
import com.infullmobile.android.infullmvp.InFullMvpPresenter
import com.infullmobile.android.infullmvp.sample.models.SharedPreferencesModel


class TemperatureCardPresenter(view: TemperatureCardView,
                               private val sharedPreferencesModel: SharedPreferencesModel)
    : InFullMvpPresenter<TemperatureCardView>(view) {

    override fun bind(extras: Bundle?, savedInstanceState: Bundle?) {
        view.updateTemperature(sharedPreferencesModel.temperature)
    }
}