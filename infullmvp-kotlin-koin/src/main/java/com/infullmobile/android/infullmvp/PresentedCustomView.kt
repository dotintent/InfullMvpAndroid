package com.infullmobile.android.infullmvp

import android.content.Context
import android.view.View


abstract class PresentedCustomView<PresenterType : InFullMvpPresenter<*>>(
        private val customView: View)
    : PresentedView<PresenterType>() {

    override val context: Context get() = customView.context
    override val containerView: View get() = customView
}