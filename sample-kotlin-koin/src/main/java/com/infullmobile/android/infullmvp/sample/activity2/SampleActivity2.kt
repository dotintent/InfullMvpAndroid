package com.infullmobile.android.infullmvp.sample.activity2

import com.infullmobile.android.infullmvp.InFullMvpActivity
import com.infullmobile.android.infullmvp.sample.R
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class SampleActivity2 : InFullMvpActivity<SampleActivity2Presenter>(), SampleActivity2View {
    override val scopeName: String = sampleActivity2ScopeName
    override val presenter: SampleActivity2Presenter by inject { parametersOf(this) }
    override val layoutId = R.layout.activity_mvp_card

    override fun onViewBound() {
    }

}