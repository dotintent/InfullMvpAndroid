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

abstract class PresentedActivityView<PresenterType : Any> : PresentedView<PresenterType, InFullMvpActivity<*, *>>() {

    private var activity: InFullMvpActivity<*, *>? = null

    override val context: Context
        get() = activity?:throw IllegalStateException("This view must be bound to activity")

    override val viewFinder: PresentedView<PresenterType, *>.(Int) -> View?
        get() = { activity?.findViewById(it) }

    override val dimensionFinder: PresentedView<PresenterType, *>.(Int) -> Int?
        get() = { activity?.getResources()?.getDimensionPixelSize(it) }

    override val stringFinder: PresentedView<PresenterType, *>.(Int) -> String?
        get() = { activity?.getResources()?.getString(it) }

    override val colorFinder: PresentedView<PresenterType, *>.(Int) -> Int?
        get() = { ContextCompat.getColor(activity, it) }

    override val drawableFinder: PresentedView<PresenterType, *>.(Int) -> Drawable?
        get() = { ContextCompat.getDrawable(activity, it) }

    override fun bindUiElements(boundingView: InFullMvpActivity<*, *>, presenter: PresenterType) {
        this.activity = boundingView
        this.boundPresenter = presenter
        onViewsBound()
    }

    open val actionBar: ActionBar?
        get() = activity?.getSupportActionBar()

    open fun setActionBar(toolbar: Toolbar) {
        activity?.setSupportActionBar(toolbar)
    }

    open fun inflateMenu(menu: Menu, menuInflater: MenuInflater) {
        /* NO OP */
    }

    open fun onOptionsItemSelected(item: MenuItem): Boolean {
        return false
    }
}
