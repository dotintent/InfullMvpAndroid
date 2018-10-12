package com.infullmobile.android.infullmvp.sample.mvpCardActivity

import com.infullmobile.android.infullmvp.InFullMvpActivity
import com.infullmobile.android.infullmvp.sample.R
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MvpCardActivity : InFullMvpActivity<MvpCardPresenter>(), MvpCardView {
    override val scopeName: String = mvpCardActivityScopeName
    override val presenter: MvpCardPresenter by inject { parametersOf(this) }
    override val layoutId = R.layout.activity_mvp_card

    override fun onViewBound() {
    }

}