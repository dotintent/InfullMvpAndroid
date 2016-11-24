package com.infullmobile.android.infullmvp

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.view.View

abstract class PresentedDialogView<presenterType: Any>: PresentedView<presenterType, Dialog>() {

    private var dialog: Dialog? = null

    val boundDialog: Dialog
        get() = dialog?:throw IllegalStateException("This view must be bound to dialog")

    override val context: Context
        get() = dialog?.context?:throw IllegalStateException("This view must be bound to dialog")

    override fun bindUiElements(boundingView: Dialog, presenter: presenterType) {
        this.dialog = boundingView
        this.boundPresenter = presenter
        onViewsBound()
    }

    override val viewFinder: PresentedView<presenterType, *>.(Int) -> View?
        get() = { dialog?.findViewById(it) }

    override val dimensionFinder: PresentedView<presenterType, *>.(Int) -> Int?
        get() = { dialog?.context?.resources?.getDimensionPixelSize(it) }

    override val stringFinder: PresentedView<presenterType, *>.(Int) -> String?
        get() = { dialog?.context?.resources?.getString(it) }

    override val colorFinder: PresentedView<presenterType, *>.(Int) -> Int?
        get() = { ContextCompat.getColor(dialog?.context, it) }

    override val drawableFinder: PresentedView<presenterType, *>.(Int) -> Drawable?
        get() = { dialog?.context?.getDrawable(it) }
}
