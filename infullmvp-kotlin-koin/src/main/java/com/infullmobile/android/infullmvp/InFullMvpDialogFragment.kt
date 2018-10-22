package com.infullmobile.android.infullmvp

import android.app.Dialog
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v4.app.DialogFragment
import android.view.MenuItem
import android.view.View
import org.koin.android.scope.ext.android.bindScope
import org.koin.android.scope.ext.android.getOrCreateScope

abstract class InFullMvpDialogFragment<out PresentedViewType : PresentedView<PresenterType>, PresenterType : InFullMvpPresenter<*>>
    : DialogFragment() {

    abstract val presenter: PresenterType
    abstract val presentedView: PresentedViewType

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindScope(getOrCreateScope(presentedView.scopeName))
    }

    override fun setupDialog(dialog: Dialog, style: Int) {
        /*
          Method is group restricted via @hide and @Restricted in source
          but we can still call it from kotlin.
          This may change with further kotlin plugin support.
         */
        super.setupDialog(dialog, style)
        dialog.setContentView(View.inflate(context, presentedView.layoutId, null))
        presenter.bind(arguments ?: Bundle(), Bundle(), activity!!.intent.data)
        presentedView.bindView(presenter)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return presenter.onContextItemSelected(item) || super.onContextItemSelected(item)
    }
}