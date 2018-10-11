package com.infullmobile.android.infullmvp.sample.customView

import org.koin.dsl.module.module

const val customViewScopeName = "customViewScopeName"
val customViewModule = module(customViewScopeName) {

    factory { (view: CustomMvpViewContract.View) -> CustomViewPresenter(view, get()) as CustomMvpViewContract.Presenter }
}