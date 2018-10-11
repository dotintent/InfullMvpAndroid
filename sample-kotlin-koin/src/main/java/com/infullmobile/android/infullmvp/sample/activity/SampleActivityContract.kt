package com.infullmobile.android.infullmvp.sample.activity

import com.infullmobile.android.infullmvp.MvpPresenter
import com.infullmobile.android.infullmvp.MvpView

interface SampleActivityContract {
    interface View : MvpView<Presenter> {
        fun updateText(text: String)
        fun openSample2()
    }

    interface Presenter : MvpPresenter<View> {
        fun openCustomViewActivity()
    }
}