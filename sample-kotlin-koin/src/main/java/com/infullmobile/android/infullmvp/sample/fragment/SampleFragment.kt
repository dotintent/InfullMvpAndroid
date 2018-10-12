package com.infullmobile.android.infullmvp.sample.fragment

import android.os.Bundle
import com.infullmobile.android.infullmvp.InFullMvpFragment
import com.infullmobile.android.infullmvp.sample.R
import kotlinx.android.synthetic.main.fragment_sample.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class SampleFragment : InFullMvpFragment<SampleFragmentPresenter>(), SampleFragmentView {
    override val scopeName: String = sampleFragmentScopeName
    override val presenter: SampleFragmentPresenter by inject { parametersOf(this) }
    override val layoutId = R.layout.fragment_sample

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