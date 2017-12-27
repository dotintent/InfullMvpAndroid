package com.infullmobile.android.infullmvp

import android.content.Context
import android.view.View

abstract class PresentedCustomView<PresenterType : Any>
    : ContextPresentedView<PresenterType, View>() {

    private var customView: View? = null

    override val context: Context
        get() = customView?.context
                ?: throw IllegalStateException("MVP View implementation should be bound to a custom Android view.")

    override val viewFinder: PresentedView<PresenterType, *>.(Int) -> View?
        get() = { customView?.findViewById(it) }

    override fun bindUiElements(boundingView: View, presenter: PresenterType) {
        customView = boundingView
        boundPresenter = presenter
        onViewsBound()
    }
}