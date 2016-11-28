package com.infullmobile.android.infullmvp

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.view.View

abstract class PresentedDialogView<PresenterType: Any>: PresentedView<PresenterType, Dialog>() {

    private var dialog: Dialog? = null

    val boundDialog: Dialog
        get() = dialog?:throw IllegalStateException("This view must be bound to dialog")

    override val context: Context
        get() = dialog?.context?:throw IllegalStateException("This view must be bound to dialog")

    override val viewFinder: PresentedView<PresenterType, *>.(Int) -> View?
        get() = { dialog?.findViewById(it) }

    override val dimensionFinder: PresentedView<PresenterType, *>.(Int) -> Int?
        get() = { dialog?.context?.resources?.getDimensionPixelSize(it) }

    override val stringFinder: PresentedView<PresenterType, *>.(Int) -> String?
        get() = { dialog?.context?.resources?.getString(it) }

    override val colorFinder: PresentedView<PresenterType, *>.(Int) -> Int?
        get() = { ContextCompat.getColor(dialog?.context, it) }

    override val drawableFinder: PresentedView<PresenterType, *>.(Int) -> Drawable?
        get() = { ContextCompat.getDrawable(dialog?.context, it) }

    override fun bindUiElements(boundingView: Dialog, presenter: PresenterType) {
        this.dialog = boundingView
        this.boundPresenter = presenter
        onViewsBound()
    }
}
