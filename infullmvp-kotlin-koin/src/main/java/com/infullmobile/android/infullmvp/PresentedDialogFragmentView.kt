package com.infullmobile.android.infullmvp

import android.content.Context
import android.support.v4.app.DialogFragment
import android.view.View


abstract class PresentedDialogFragmentView<PresenterType : InFullMvpPresenter<*>>(
        private val dialogFragment: DialogFragment)
    : PresentedView<PresenterType>() {

    override val context: Context
        get() = dialogFragment.dialog.context
                ?: throw IllegalStateException("This presentedView fragment is not connected to context")
    override val containerView: View
        get() = dialogFragment.dialog.window!!.decorView
                ?: throw IllegalStateException("This presentedView fragment is not connected to view")
}