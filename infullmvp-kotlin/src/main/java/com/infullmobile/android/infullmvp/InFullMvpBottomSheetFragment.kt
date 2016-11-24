package com.infullmobile.android.infullmvp

import android.app.Dialog
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.view.View

abstract class InFullMvpBottomSheetFragment<K : Presenter<T>, out T : PresentedDialogView<K>> : BottomSheetDialogFragment() {

    override fun setupDialog(dialog: Dialog, style: Int) {
        super.setupDialog(dialog, style)
        injectIntoGraph()
        val rootView = View.inflate(context, presentedView.layoutResId, null)
        dialog.setContentView(rootView)
        presentedView.bindUiElements(dialog, presenter)
        presenter.bind(arguments?: Bundle())
    }

    abstract val presenter: K
    abstract val presentedView: T
    abstract fun injectIntoGraph()
}