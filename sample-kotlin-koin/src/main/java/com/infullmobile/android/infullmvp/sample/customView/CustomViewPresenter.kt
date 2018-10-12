package com.infullmobile.android.infullmvp.sample.customView

import android.os.Bundle
import com.infullmobile.android.infullmvp.InFullMvpPresenter
import com.infullmobile.android.infullmvp.sample.models.SharedPreferencesModel


class CustomViewPresenter(view: CustomViewView,
                          private val sharedPreferencesModel: SharedPreferencesModel)
    : InFullMvpPresenter<CustomViewView>(view) {

    override fun bind(extras: Bundle?, savedInstanceState: Bundle?) {
        view.updateText(sharedPreferencesModel.temperature)
    }
}