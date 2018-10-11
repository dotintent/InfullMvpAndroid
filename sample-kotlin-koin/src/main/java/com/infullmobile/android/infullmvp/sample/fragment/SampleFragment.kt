package com.infullmobile.android.infullmvp.sample.fragment

import android.os.Bundle
import com.infullmobile.android.infullmvp.InFullMvpFragment
import com.infullmobile.android.infullmvp.sample.R
import kotlinx.android.synthetic.main.fragment_sample.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class SampleFragment : InFullMvpFragment<SampleFragmentContract.View, SampleFragmentContract.Presenter>(), SampleFragmentContract.View {
    override val scopeName: String = sampleFragmentScopeName
    override val presenter: SampleFragmentContract.Presenter by inject { parametersOf(this) }
    override val layoutId = R.layout.fragment_sample

    override fun onViewBound() {
    }

    override fun updateText(text: String) {
        fragmentTextContainer.text = text
    }

    companion object {
        fun newInstance(text: String) = SampleFragment().apply {
            arguments = Bundle().apply {
                putString(SampleFragmentPresenter.TEXT_EXTRA_KEY, text)
            }
        }
    }
}