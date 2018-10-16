package com.infullmobile.android.infullmvp.sample.activity

import android.net.Uri
import android.os.Bundle
import com.infullmobile.android.infullmvp.InFullMvpPresenter
import com.infullmobile.android.infullmvp.sample.models.SharedPreferencesModel


class SampleKoinPresenter(view: SampleKoinView,
                          private val sharedPreferencesModel: SharedPreferencesModel
) : InFullMvpPresenter<SampleKoinView>(view) {

    override fun bind(intentBundle: Bundle, savedInstanceState: Bundle, intentData: Uri?) {
        view.updateText(sharedPreferencesModel.welcomeText)
    }

    fun openCustomViewActivity() {
        sharedPreferencesModel.welcomeText = "test"
        view.openMvpCardActivity()
    }
}