package com.infullmobile.android.infullmvp

import android.content.Context

interface MvpView {

    val androidContext: Context

    fun onViewBound() {

    }
}