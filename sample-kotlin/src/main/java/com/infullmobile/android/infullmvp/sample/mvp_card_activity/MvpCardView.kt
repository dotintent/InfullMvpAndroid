package com.infullmobile.android.infullmvp.sample.mvp_card_activity

import android.support.annotation.LayoutRes
import com.infullmobile.android.infullmvp.PresentedActivityView
import com.infullmobile.android.infullmvp.sample.R


open class MvpCardView : PresentedActivityView<MvpCardPresenter>() {

    @LayoutRes override val layoutResId = R.layout.activity_mvp_card

    override fun onViewsBound() {
        /* NO OP */
    }
}