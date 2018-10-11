package com.infullmobile.android.infullmvp.sample.customView

import android.os.Bundle
import com.infullmobile.android.infullmvp.MvpPresenter
import com.infullmobile.android.infullmvp.sample.models.SharedPreferencesModel


class CustomViewPresenter(override var view: CustomMvpViewContract.View,
                          private val sharedPreferencesModel: SharedPreferencesModel)
    : MvpPresenter<CustomMvpViewContract.View>, CustomMvpViewContract.Presenter {

    override fun bind(extras: Bundle?, savedInstanceState: Bundle?) {
        view.updateText(sharedPreferencesModel.temperature)
    }
}