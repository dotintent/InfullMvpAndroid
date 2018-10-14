package com.infullmobile.android.infullmvp.sample.temperatureCard

import android.view.View
import org.koin.dsl.module.module

const val temperatureCardScopeName = "temperatureCardScopeName"
val temperatureCardModule = module(temperatureCardScopeName) {

    factory { (customView: TemperatureCard) -> TemperatureCardPresenter(customView.view, get()) }
    factory { (view: View) -> TemperatureCardView(view) }
}