package com.infullmobile.android.infullmvp

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View

abstract class PresentedActivityView<presenterType : Any> : PresentedView<presenterType, InFullMvpActivity<*, *>>() {

    private var activity: InFullMvpActivity<*, *>? = null

    override val context: Context
        get() = activity?:throw IllegalStateException("This view must be bound to activity")

    override fun bindUiElements(boundingView: InFullMvpActivity<*, *>, presenter: presenterType) {
        this.activity = boundingView
        this.boundPresenter = presenter
        onViewsBound()
    }
    override val viewFinder: PresentedView<presenterType, *>.(Int) -> View?
        get() = { activity?.findViewById(it) }

    override val dimensionFinder: PresentedView<presenterType, *>.(Int) -> Int?
        get() = { activity?.getResources()?.getDimensionPixelSize(it) }

    override val stringFinder: PresentedView<presenterType, *>.(Int) -> String?
        get() = { activity?.getResources()?.getString(it) }

    override val colorFinder: PresentedView<presenterType, *>.(Int) -> Int?
        get() = { ContextCompat.getColor(activity, it) }

    override val drawableFinder: PresentedView<presenterType, *>.(Int) -> Drawable?
        get() = { ContextCompat.getDrawable(activity, it) }

    open val actionBar: ActionBar?
        get() = activity?.getSupportActionBar()

    open fun setActionBar(toolbar: Toolbar) {
        activity?.setSupportActionBar(toolbar)
    }

    open fun inflateMenu(menu: Menu, menuInflater: MenuInflater) {
        // NO OP
    }

    open fun onOptionsItemSelected(item: MenuItem): Boolean {
        return false
    }
}
