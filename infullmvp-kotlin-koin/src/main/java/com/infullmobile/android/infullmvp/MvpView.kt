package com.infullmobile.android.infullmvp

import android.content.Context

interface MvpView {

    val context: Context

    fun onViewBound() {

    }
}