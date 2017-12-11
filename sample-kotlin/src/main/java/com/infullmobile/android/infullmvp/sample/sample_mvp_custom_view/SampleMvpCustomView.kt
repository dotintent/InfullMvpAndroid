package com.infullmobile.android.infullmvp.sample.sample_mvp_custom_view

import android.content.Context
import android.util.AttributeSet
import com.infullmobile.android.infullmvp.InFullMvpView
import com.infullmobile.android.infullmvp.sample.sample_mvp_custom_view.di.SampleViewGraph
import javax.inject.Inject

class SampleMvpCustomView(
        override val parentContext: Context,
        private val attrs: AttributeSet?
) : InFullMvpView<SampleMvpCustomViewPresenter,
        SampleMvpCustomViewView>(parentContext, attrs) {

    @Inject override lateinit var presenter: SampleMvpCustomViewPresenter
    @Inject override lateinit var presentedView: SampleMvpCustomViewView
    private lateinit var sampleActivityGraph: SampleViewGraph

    constructor(parentContext: Context) : this(parentContext, null)

    override fun injectIntoGraph() {
        sampleActivityGraph = SampleViewGraph(parentContext, attrs)
        sampleActivityGraph.inject(this)
    }
}