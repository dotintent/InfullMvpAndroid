package com.infullmobile.android.infullmvp.sample.fragment

import com.infullmobile.android.infullmvp.MvpPresenter
import com.infullmobile.android.infullmvp.MvpView

interface SampleFragmentContract {
    interface View : MvpView<Presenter> {
        fun updateText(text: String)
    }

    interface Presenter : MvpPresenter<View>
}
