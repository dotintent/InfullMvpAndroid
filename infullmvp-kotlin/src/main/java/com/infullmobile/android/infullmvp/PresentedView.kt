package com.infullmobile.android.infullmvp

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import kotlin.properties.ReadOnlyProperty

abstract class PresentedView<PresenterType : Any, in PresentedViewType: Any> {

    protected lateinit var boundPresenter: PresenterType

    abstract val context: Context
    abstract val layoutResId: Int
    abstract val viewFinder: PresentedView<PresenterType, *>.(Int) -> View?
    abstract val dimensionFinder: PresentedView<PresenterType, *>.(Int) -> Int?
    abstract val stringFinder: PresentedView<PresenterType, *>.(Int) -> String?
    abstract val colorFinder: PresentedView<PresenterType, *>.(Int) -> Int?
    abstract val drawableFinder: PresentedView<PresenterType, *>.(Int) -> Drawable?

    abstract fun bindUiElements(boundingView: PresentedViewType, presenter: PresenterType)
    abstract fun onViewsBound()

    val presenter: PresenterType
        get() = boundPresenter

    protected fun <V : View> PresentedView<PresenterType, *>.bindView(id: Int)
            : ReadOnlyProperty<PresentedView<PresenterType, *>, V> {
        return required(id, viewFinder)
    }

    protected fun PresentedView<PresenterType, *>.bindDimen(id: Int)
            : ReadOnlyProperty<PresentedView<PresenterType, *>, Int> {
        return requiredDimen(id, dimensionFinder)
    }

    protected fun PresentedView<PresenterType, *>.bindString(id: Int)
            : Lazy<PresentedView<PresenterType, *>, String> {
        return requiredString(id, stringFinder)
    }

    protected fun PresentedView<PresenterType, *>.bindColor(id: Int)
            : Lazy<PresentedView<PresenterType, *>, Int> {
        return requiredColor(id, colorFinder)
    }

    protected fun PresentedView<PresenterType, *>.bindDrawable(id: Int)
            : Lazy<PresentedView<PresenterType, *>, Drawable> {
        return requiredDrawable(id, drawableFinder)
    }
}
