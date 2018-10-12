package com.infullmobile.android.infullmvp.sample.activity

import com.infullmobile.android.infullmvp.MvpView

interface SampleKoinView : MvpView {
    fun updateText(text: String)
    fun openSample2()
}