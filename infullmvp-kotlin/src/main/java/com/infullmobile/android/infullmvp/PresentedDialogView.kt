package com.infullmobile.android.infullmvp

import android.app.Dialog
import android.content.Context
import android.view.View

abstract class PresentedDialogView<PresenterType: Any>: ContextPresentedView<PresenterType, Dialog>() {

    private var dialog: Dialog? = null

    val boundDialog: Dialog
        get() = dialog?:throw IllegalStateException("This view must be bound to dialog")

    override val context: Context
        get() = dialog?.context?:throw IllegalStateException("This view must be bound to dialog")

    override val viewFinder: PresentedView<PresenterType, *>.(Int) -> View?
        get() = { dialog?.findViewById(it) }

    override fun bindUiElements(boundingView: Dialog, presenter: PresenterType) {
        dialog = boundingView
        boundPresenter = presenter
        onViewsBound()
    }
}
