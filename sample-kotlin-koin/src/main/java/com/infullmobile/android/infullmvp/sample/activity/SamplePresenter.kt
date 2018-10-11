package com.infullmobile.android.infullmvp.sample.activity

import android.os.Bundle
import com.infullmobile.android.infullmvp.InFullMvpPresenter
import com.infullmobile.android.infullmvp.sample.models.SharedPreferencesModel


class SamplePresenter(view: SampleActivityContract.View,
                      private val sharedPreferencesModel: SharedPreferencesModel
) : InFullMvpPresenter<SampleActivityContract.View>(view), SampleActivityContract.Presenter {

    override fun bind(extras: Bundle?, savedInstanceState: Bundle?) {
        view.updateText(sharedPreferencesModel.welcomeText)
    }

    override fun openCustomViewActivity() {
        sharedPreferencesModel.welcomeText = "test"
        view.openSample2()
    }
}