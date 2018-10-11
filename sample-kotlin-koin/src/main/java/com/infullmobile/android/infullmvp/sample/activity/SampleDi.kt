package com.infullmobile.android.infullmvp.sample.activity

import org.koin.dsl.module.module

const val sampleActivityScopeName = "sampleActivityScopeName"
val sampleActivityModule = module(sampleActivityScopeName) {

    factory { (view: SampleActivityContract.View) -> SamplePresenter(view, get()) as SampleActivityContract.Presenter }
}