package com.infullmobile.android.infullmvp.sample.activity

import com.infullmobile.android.infullmvp.InFullMvpActivity
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class SampleKoinActivity : InFullMvpActivity<SampleKoinView, SampleKoinPresenter>() {

    override val presenter: SampleKoinPresenter by inject { parametersOf(this) }
    override val presentedView: SampleKoinView by inject { parametersOf(this) }

}