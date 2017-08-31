package com.infullmobile.android.infullmvp

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.MenuItem
import android.view.View

abstract class InFullMvpDialogFragment<
        PresenterType : Presenter<PresentedViewType>,
        out PresentedViewType : PresentedDialogView<PresenterType>
        > : DialogFragment() {

    abstract val presenter: PresenterType
    abstract val presentedView: PresentedViewType

    abstract fun injectIntoGraph()

    override fun setupDialog(dialog: Dialog, style: Int) {
        /*
          Method is group restricted via @hide and @Restricted in source
          but we can still call it from kotlin.
          This may change with further kotlin plugin support.
         */
        super.setupDialog(dialog, style)
        injectIntoGraph()
        val rootView = View.inflate(context, presentedView.layoutResId, null)
        dialog.setContentView(rootView)
        presentedView.bindUiElements(dialog, presenter)
        presenter.bind(arguments ?: Bundle(), Bundle(), activity.intent.data)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        return presenter.onContextItemSelected(item) || super.onContextItemSelected(item)
    }
}