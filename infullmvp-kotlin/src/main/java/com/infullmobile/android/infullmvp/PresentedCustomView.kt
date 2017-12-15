package com.infullmobile.android.infullmvp

import android.content.Context
import android.view.View

abstract class PresentedCustomView<PresenterType : Any>
    : ContextPresentedView<PresenterType, View>() {

    private var customView: View? = null

    override val context: Context
        get() = customView?.context ?: throw IllegalStateException("This view must be bound to custom view")

    override val viewFinder: PresentedView<PresenterType, *>.(Int) -> View?
        get() = { customView?.findViewById(it) }

    override fun bindUiElements(boundingView: View, presenter: PresenterType) {
        this.customView = boundingView
        this.boundPresenter = presenter
        onViewsBound()
    }

}