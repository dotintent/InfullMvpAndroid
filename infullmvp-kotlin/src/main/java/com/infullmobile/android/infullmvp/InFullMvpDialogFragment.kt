package com.infullmobile.android.infullmvp

import android.app.Dialog
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.view.View

abstract class InFullMvpDialogFragment<
        PresenterType : Presenter<PresentedViewType>,
        out PresentedViewType : PresentedDialogView<PresenterType>
        > : BottomSheetDialogFragment() {

    abstract val presenter: PresenterType
    abstract val presentedView: PresentedViewType

    abstract fun injectIntoGraph()

    override fun setupDialog(dialog: Dialog, style: Int) {
        super.setupDialog(dialog, style)
        injectIntoGraph()
        val rootView = View.inflate(context, presentedView.layoutResId, null)
        dialog.setContentView(rootView)
        presentedView.bindUiElements(dialog, presenter)
        presenter.bind(arguments?: Bundle(), Bundle())
    }
}