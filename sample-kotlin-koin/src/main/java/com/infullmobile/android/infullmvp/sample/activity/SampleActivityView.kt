package com.infullmobile.android.infullmvp.sample.activity

import com.infullmobile.android.infullmvp.MvpView

interface SampleActivityView : MvpView {
    fun updateText(text: String)
    fun openSample2()
}