package com.infullmobile.android.infullmvp.sample.activity

import android.os.Bundle

import com.infullmobile.android.infullmvp.InFullMvpActivity
import com.infullmobile.android.infullmvp.sample.activity.di.SampleActivityGraph

import javax.inject.Inject

class SampleActivity : InFullMvpActivity<SampleActivityPresenter, SampleActivityView>() {

    @Inject lateinit var sampleActivityPresenter: SampleActivityPresenter
    @Inject lateinit var sampleActivityView: SampleActivityView
    lateinit var sampleActivityGraph: SampleActivityGraph

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sampleActivityGraph = SampleActivityGraph(this)
    }

    override fun injectIntoGraph() {
        sampleActivityGraph.inject(this)
    }

    override val presenter: SampleActivityPresenter
        get() = sampleActivityPresenter
    override val presentedView: SampleActivityView
        get() = sampleActivityView
}
