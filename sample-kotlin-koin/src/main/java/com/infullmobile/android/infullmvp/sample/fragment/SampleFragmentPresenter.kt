package com.infullmobile.android.infullmvp.sample.fragment

import android.net.Uri
import android.os.Bundle
import com.infullmobile.android.infullmvp.InFullMvpPresenter
import com.infullmobile.android.infullmvp.sample.models.SharedPreferencesModel

class SampleFragmentPresenter(view: SampleFragmentView,
                              private val sharedPreferencesModel: SharedPreferencesModel)
    : InFullMvpPresenter<SampleFragmentView>(view) {

    override fun bind(intentBundle: Bundle, savedInstanceState: Bundle, intentData: Uri?) {
        view.updateText(intentBundle.getString(TEXT_EXTRA_KEY)!!)
    }

    companion object {
        const val TEXT_EXTRA_KEY = "text"
    }
}