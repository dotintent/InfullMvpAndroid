package com.infullmobile.android.infullmvp.sample.activity2

import com.infullmobile.android.infullmvp.MvpPresenter
import com.infullmobile.android.infullmvp.MvpView

interface SampleActivity2Contract {
    interface View : MvpView<Presenter>

    interface Presenter : MvpPresenter<View>
}
