package com.infullmobile.android.infullmvp.sample.fragment

import org.koin.dsl.module.module

const val sampleFragmentScopeName = "sampleFragmentScopeName"
val sampleFragmentModule = module(sampleFragmentScopeName) {

    factory { (view: SampleFragmentContract.View) -> SampleFragmentPresenter(view, get()) as SampleFragmentContract.Presenter }
}