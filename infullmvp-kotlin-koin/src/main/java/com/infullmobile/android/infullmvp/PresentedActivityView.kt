package com.infullmobile.android.infullmvp

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.view.View


abstract class PresentedActivityView<PresenterType : InFullMvpPresenter<*>>(
        private val activity: AppCompatActivity)
    : PresentedView<PresenterType>() {

    override val context: Context get() = activity
    override val containerView: View get() = activity.window.decorView.rootView
}