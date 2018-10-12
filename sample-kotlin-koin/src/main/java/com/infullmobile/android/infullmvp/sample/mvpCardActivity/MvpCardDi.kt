package com.infullmobile.android.infullmvp.sample.mvpCardActivity

import org.koin.dsl.module.module

const val mvpCardActivityScopeName = "mvpCardActivityScopeName"
val sampleActivity2Module = module(mvpCardActivityScopeName) {

    factory { (view: MvpCardView) -> MvpCardPresenter(view) }
}