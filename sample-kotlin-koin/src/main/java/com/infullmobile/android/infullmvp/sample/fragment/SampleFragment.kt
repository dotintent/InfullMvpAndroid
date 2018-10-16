package com.infullmobile.android.infullmvp.sample.fragment

import android.os.Bundle
import com.infullmobile.android.infullmvp.InFullMvpFragment
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class SampleFragment : InFullMvpFragment<SampleFragmentView, SampleFragmentPresenter>() {

    override val presenter: SampleFragmentPresenter by inject { parametersOf(this) }
    override val presentedView: SampleFragmentView by inject { parametersOf(this) }

    companion object {
        fun newInstance(text: String) = SampleFragment().apply {
            arguments = Bundle().apply {
                putString(SampleFragmentPresenter.TEXT_EXTRA_KEY, text)
            }
        }
    }
}