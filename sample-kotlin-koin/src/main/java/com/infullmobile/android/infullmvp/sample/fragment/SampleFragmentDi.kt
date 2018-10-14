package com.infullmobile.android.infullmvp.sample.fragment

import android.support.v4.app.Fragment
import org.koin.dsl.module.module

const val sampleFragmentScopeName = "sampleFragmentScopeName"
val sampleFragmentModule = module(sampleFragmentScopeName) {
    factory { (fragment: SampleFragment) -> SampleFragmentPresenter(fragment.view, get()) }
    factory { (fragment: Fragment) -> SampleFragmentView(fragment) }
}