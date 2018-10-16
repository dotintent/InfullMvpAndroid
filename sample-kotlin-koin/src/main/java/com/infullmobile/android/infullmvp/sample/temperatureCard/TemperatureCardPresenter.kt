package com.infullmobile.android.infullmvp.sample.temperatureCard

import android.net.Uri
import android.os.Bundle
import com.infullmobile.android.infullmvp.InFullMvpPresenter
import com.infullmobile.android.infullmvp.sample.models.SharedPreferencesModel


class TemperatureCardPresenter(view: TemperatureCardView,
                               private val sharedPreferencesModel: SharedPreferencesModel)
    : InFullMvpPresenter<TemperatureCardView>(view) {

    override fun bind(intentBundle: Bundle, savedInstanceState: Bundle, intentData: Uri?) {
        view.updateTemperature(sharedPreferencesModel.temperature)
    }
}