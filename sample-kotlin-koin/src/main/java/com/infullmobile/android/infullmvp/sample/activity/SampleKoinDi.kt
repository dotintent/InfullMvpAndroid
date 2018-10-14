package com.infullmobile.android.infullmvp.sample.activity

import android.support.v7.app.AppCompatActivity
import org.koin.dsl.module.module

const val sampleKoinActivityScopeName = "sampleKoinActivityScopeName"
val sampleKoinActivityModule = module(sampleKoinActivityScopeName) {
    factory { (activity: AppCompatActivity) -> SampleKoinView(activity) }
    factory { (activity: SampleKoinActivity) -> SampleKoinPresenter(activity.view, get()) }
    factory { (activity: SampleKoinActivity) -> TwoSimplePagesAdapter(activity.supportFragmentManager) }
}