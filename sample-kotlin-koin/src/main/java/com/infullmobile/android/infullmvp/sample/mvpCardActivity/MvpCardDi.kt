package com.infullmobile.android.infullmvp.sample.mvpCardActivity

import android.support.v7.app.AppCompatActivity
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module.module

const val mvpCardActivityScopeName = "mvpCardActivityScopeName"
val sampleActivity2Module = module(mvpCardActivityScopeName) {

    factory { (activity: AppCompatActivity) -> MvpCardView(activity) }
    factory { (activity: AppCompatActivity) -> MvpCardPresenter(get("", mvpCardActivityScopeName) { parametersOf(activity) }) }
}