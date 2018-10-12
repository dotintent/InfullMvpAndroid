package com.infullmobile.android.infullmvp.sample.fragment

import android.os.Bundle
import com.infullmobile.android.infullmvp.InFullMvpPresenter
import com.infullmobile.android.infullmvp.sample.models.SharedPreferencesModel

class SampleFragmentPresenter(view: SampleFragmentView,
                              private val sharedPreferencesModel: SharedPreferencesModel)
    : InFullMvpPresenter<SampleFragmentView>(view) {

    override fun bind(extras: Bundle?, savedInstanceState: Bundle?) {
        view.updateText(extras!!.getString(TEXT_EXTRA_KEY)!!)
    }

    companion object {
        const val TEXT_EXTRA_KEY = "text"
    }
}