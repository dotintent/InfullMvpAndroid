package com.infullmobile.android.infullmvp.sample.activity

import android.os.Bundle
import com.infullmobile.android.infullmvp.InFullMvpPresenter
import com.infullmobile.android.infullmvp.sample.models.SharedPreferencesModel


class SampleKoinPresenter(view: SampleKoinView,
                          private val sharedPreferencesModel: SharedPreferencesModel
) : InFullMvpPresenter<SampleKoinView>(view) {

    override fun bind(extras: Bundle?, savedInstanceState: Bundle?) {
        view.updateText(sharedPreferencesModel.welcomeText)
    }

    fun openCustomViewActivity() {
        sharedPreferencesModel.welcomeText = "test"
        view.openMvpCardActivity()
    }
}