package com.infullmobile.android.infullmvp

import android.content.Context
import android.support.v4.app.Fragment
import android.view.View


abstract class PresentedFragmentView<PresenterType : InFullMvpPresenter<*>>(
        private val fragment: Fragment)
    : PresentedView<PresenterType>() {

    override val context: Context
        get() = fragment.context
                ?: throw IllegalStateException("This view fragment is not connected to context")
    override val containerView: View
        get() = fragment.view
                ?: throw IllegalStateException("This view fragment is not connected to context")
}