package com.infullmobile.android.infullmvp.sample.dialogFragment

import android.support.v4.app.DialogFragment
import com.infullmobile.android.infullmvp.PresentedDialogFragmentView
import com.infullmobile.android.infullmvp.sample.R
import kotlinx.android.synthetic.main.fragment_sample.*

class SampleDialogFragmentView(fragment: DialogFragment) : PresentedDialogFragmentView<SampleDialogFragmentPresenter>(fragment) {
    override val scopeName = sampleDialogFragmentScopeName
    override val layoutId = R.layout.fragment_sample

    fun updateText(text: String) {
        fragmentTextContainer.text = text
    }
}