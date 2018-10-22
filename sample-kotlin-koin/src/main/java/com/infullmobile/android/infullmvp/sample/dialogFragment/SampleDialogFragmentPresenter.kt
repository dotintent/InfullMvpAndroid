package com.infullmobile.android.infullmvp.sample.dialogFragment

import android.net.Uri
import android.os.Bundle
import com.infullmobile.android.infullmvp.InFullMvpPresenter
import com.infullmobile.android.infullmvp.sample.R

class SampleDialogFragmentPresenter(view: SampleDialogFragmentView)
    : InFullMvpPresenter<SampleDialogFragmentView>(view) {

    override fun bind(intentBundle: Bundle, savedInstanceState: Bundle, intentData: Uri?) {
        view.updateText(view.context.getString(R.string.im_custom_dialog))
    }

}