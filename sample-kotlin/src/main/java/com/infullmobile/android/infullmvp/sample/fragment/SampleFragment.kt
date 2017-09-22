package com.infullmobile.android.infullmvp.sample.fragment

import com.infullmobile.android.infullmvp.InFullMvpFragment
import com.infullmobile.android.infullmvp.sample.fragment.di.SampleFragmentGraph
import javax.inject.Inject

class SampleFragment : InFullMvpFragment<SampleFragmentPresenter, SampleFragmentView>() {

    @Inject internal lateinit var sampleFragmentPresenter: SampleFragmentPresenter
    @Inject internal lateinit var sampleFragmentView: SampleFragmentView
    val sampleFragmentGraph = SampleFragmentGraph(this)

    override fun injectIntoGraph() {
        sampleFragmentGraph.inject(this)
    }

    override val presenter: SampleFragmentPresenter
        get() = sampleFragmentPresenter
    override val presentedView: SampleFragmentView
        get() = sampleFragmentView
}
