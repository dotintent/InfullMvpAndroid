package com.infullmobile.android.infullmvp

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.view.View

abstract class PresentedFragmentView<PresenterType: Any> : PresentedView<PresenterType, View>() {

    private var fragmentRootView: View? = null

    override val context: Context
        get() = fragmentRootView?.context?:throw IllegalStateException("This view must be bound to fragment")

    override val viewFinder: PresentedView<PresenterType, *>.(Int) -> View?
        get() = { fragmentRootView?.findViewById(it) }

    override val dimensionFinder: PresentedView<PresenterType, *>.(Int) -> Int?
        get() = { fragmentRootView?.resources?.getDimensionPixelSize(it) }

    override val stringFinder: PresentedView<PresenterType, *>.(Int) -> String?
        get() = { fragmentRootView?.resources?.getString(it) }

    override val colorFinder: PresentedView<PresenterType, *>.(Int) -> Int?
        get() = { fragmentRootView?.resources?.getInteger(it) }

    override val drawableFinder: PresentedView<PresenterType, *>.(Int) -> Drawable?
        get() = { ContextCompat.getDrawable(fragmentRootView?.context, it) }

    override fun bindUiElements(boundingView: View, presenter: PresenterType) {
        this.fragmentRootView = boundingView
        this.boundPresenter = presenter
        onViewsBound()
    }
}
