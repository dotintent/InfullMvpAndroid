package com.infullmobile.android.infullmvp.sample.fragment

import com.infullmobile.android.infullmvp.MvpView

interface SampleFragmentView : MvpView {
    fun updateText(text: String)
}
