package com.infullmobile.android.infullmvp

import android.content.Context
import android.view.View

abstract class PresentedCustomView<PresenterType : Any>
    : ContextPresentedView<PresenterType, InFullMvpView<*, *>>() {

    private var customView: InFullMvpView<*, *>? = null

    override val context: Context
        get() = customView?.getContext() ?: throw IllegalStateException("This view must be bound to custom view")

    override val viewFinder: PresentedView<PresenterType, *>.(Int) -> View?
        get() = { customView?.view?.findViewById(it) }

    override fun bindUiElements(boundingView: InFullMvpView<*, *>, presenter: PresenterType) {
        this.customView = boundingView
        this.boundPresenter = presenter
        onViewsBound()
    }

}