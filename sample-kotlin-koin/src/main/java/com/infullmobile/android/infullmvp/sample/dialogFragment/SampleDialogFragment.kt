package com.infullmobile.android.infullmvp.sample.dialogFragment

import com.infullmobile.android.infullmvp.InFullMvpDialogFragment
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class SampleDialogFragment : InFullMvpDialogFragment<SampleDialogFragmentView, SampleDialogFragmentPresenter>() {

    override val presenter: SampleDialogFragmentPresenter by inject { parametersOf(this) }
    override val presentedView: SampleDialogFragmentView by inject { parametersOf(this) }

}