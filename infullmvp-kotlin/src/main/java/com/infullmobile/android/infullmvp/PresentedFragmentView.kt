package com.infullmobile.android.infullmvp

import android.content.Context
import android.view.View

abstract class PresentedFragmentView<PresenterType: Any> : ContextPresentedView<PresenterType, View>() {

    private var fragmentRootView: View? = null

    override val context: Context
        get() = fragmentRootView?.context?:throw IllegalStateException("This view must be bound to fragment")

    override val viewFinder: PresentedView<PresenterType, *>.(Int) -> View?
        get() = { fragmentRootView?.findViewById(it) }


    override fun bindUiElements(boundingView: View, presenter: PresenterType) {
        this.fragmentRootView = boundingView
        this.boundPresenter = presenter
        onViewsBound()
    }
}
