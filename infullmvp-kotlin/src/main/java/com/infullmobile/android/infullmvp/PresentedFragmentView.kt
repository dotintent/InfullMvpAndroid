package com.infullmobile.android.infullmvp

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.view.View

abstract class PresentedFragmentView<presenterType: Any> : PresentedView<presenterType, View>() {

    private var fragmentRootView: View? = null

    override val context: Context
        get() = fragmentRootView?.context?:throw IllegalStateException("This view must be bound to fragment")

    override fun bindUiElements(boundingView: View, presenter: presenterType) {
        this.fragmentRootView = boundingView
        this.boundPresenter = presenter
        onViewsBound()
    }

    override val viewFinder: PresentedView<presenterType, *>.(Int) -> View?
        get() = { fragmentRootView?.findViewById(it) }

    override val dimensionFinder: PresentedView<presenterType, *>.(Int) -> Int?
        get() = { fragmentRootView?.resources?.getDimensionPixelSize(it) }

    override val stringFinder: PresentedView<presenterType, *>.(Int) -> String?
        get() = { fragmentRootView?.resources?.getString(it) }

    override val colorFinder: PresentedView<presenterType, *>.(Int) -> Int?
        get() = { fragmentRootView?.resources?.getInteger(it) }

    override val drawableFinder: PresentedView<presenterType, *>.(Int) -> Drawable?
        get() = { ContextCompat.getDrawable(fragmentRootView?.context, it) }
}
