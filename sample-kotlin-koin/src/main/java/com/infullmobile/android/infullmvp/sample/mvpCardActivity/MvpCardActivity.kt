package com.infullmobile.android.infullmvp.sample.mvpCardActivity

import com.infullmobile.android.infullmvp.InFullMvpActivity
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MvpCardActivity : InFullMvpActivity<MvpCardView, MvpCardPresenter>() {
    override val presenter: MvpCardPresenter by inject { parametersOf(this) }
    override val presentedView: MvpCardView by inject { parametersOf(this) }
}