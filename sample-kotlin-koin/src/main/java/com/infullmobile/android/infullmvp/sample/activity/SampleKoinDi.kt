package com.infullmobile.android.infullmvp.sample.activity

import org.koin.dsl.module.module

const val sampleKoinActivityScopeName = "sampleKoinActivityScopeName"
val sampleKoinActivityModule = module(sampleKoinActivityScopeName) {
    factory { (view: SampleKoinView) -> SampleKoinPresenter(view, get()) }
}