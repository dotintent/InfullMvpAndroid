package com.infullmobile.android.infullmvp.sample.activity2

import com.infullmobile.android.infullmvp.InFullMvpPresenter


class SamplePresenter2(view: SampleActivity2Contract.View)
    : InFullMvpPresenter<SampleActivity2Contract.View>(view), SampleActivity2Contract.Presenter {
}