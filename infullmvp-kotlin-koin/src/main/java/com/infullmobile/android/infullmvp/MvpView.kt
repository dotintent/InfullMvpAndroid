package com.infullmobile.android.infullmvp

import android.app.Activity

interface MvpView<out T : MvpPresenter<*>> {

    val presenter: T
    val activity: Activity

    fun onViewBound() {

    }
}