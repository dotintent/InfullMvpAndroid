package com.infullmobile.android.infullmvp.sample.activity2

import org.koin.dsl.module.module

const val sampleActivity2ScopeName = "sampleActivity2ScopeName"
val sampleActivity2Module = module(sampleActivity2ScopeName) {

    factory { (view: SampleActivity2View) -> SampleActivity2Presenter(view) }
}