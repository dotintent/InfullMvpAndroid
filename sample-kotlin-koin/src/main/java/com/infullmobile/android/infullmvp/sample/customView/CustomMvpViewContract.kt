package com.infullmobile.android.infullmvp.sample.customView

import com.infullmobile.android.infullmvp.MvpPresenter

interface CustomMvpViewContract {
    interface View {
        fun updateText(text: String)
    }

    interface Presenter : MvpPresenter<View>
}
