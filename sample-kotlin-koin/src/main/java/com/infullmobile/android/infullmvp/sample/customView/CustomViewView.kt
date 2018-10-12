package com.infullmobile.android.infullmvp.sample.customView

import com.infullmobile.android.infullmvp.MvpView

interface CustomViewView : MvpView {
    fun updateText(text: String)
}