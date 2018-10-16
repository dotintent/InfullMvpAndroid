package com.infullmobile.android.infullmvp.sample.mvpCardActivity

import android.support.v7.app.AppCompatActivity
import com.infullmobile.android.infullmvp.PresentedActivityView
import com.infullmobile.android.infullmvp.sample.R

class MvpCardView(activity: AppCompatActivity) : PresentedActivityView<MvpCardPresenter>(activity) {
    override val scopeName: String = mvpCardActivityScopeName
    override val layoutId = R.layout.activity_mvp_card

}
