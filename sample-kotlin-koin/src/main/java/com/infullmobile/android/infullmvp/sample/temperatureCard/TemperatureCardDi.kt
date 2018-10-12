package com.infullmobile.android.infullmvp.sample.temperatureCard

import org.koin.dsl.module.module

const val temperatureCardScopeName = "temperatureCardScopeName"
val temperatureCardModule = module(temperatureCardScopeName) {

    factory { (view: TemperatureCardView) -> TemperatureCarPresenter(view, get()) }
}