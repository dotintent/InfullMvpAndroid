package com.infullmobile.android.infullmvp

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlin.properties.ReadOnlyProperty

abstract class PresentedView<presenterType : Any, in viewType: Any> {

    protected lateinit var boundPresenter: presenterType

    val presenter: presenterType
        get() = boundPresenter

    abstract val context: Context
    abstract val layoutResId: Int

    abstract fun bindUiElements(boundingView: viewType, presenter: presenterType)
    abstract fun onViewsBound()

    protected fun <V : View> PresentedView<presenterType, *>.bindView(id: Int)
            : ReadOnlyProperty<PresentedView<presenterType, *>, V> {
        return required(id, viewFinder)
    }

    protected fun PresentedView<presenterType, *>.bindDimen(id: Int)
            : ReadOnlyProperty<PresentedView<presenterType, *>, Int> {
        return requiredDimen(id, dimensionFinder)
    }

    protected fun PresentedView<presenterType, *>.bindString(id: Int)
            : Lazy<PresentedView<presenterType, *>, String> {
        return requiredString(id, stringFinder)
    }

    protected fun PresentedView<presenterType, *>.bindColor(id: Int)
            : Lazy<PresentedView<presenterType, *>, Int> {
        return requiredColor(id, colorFinder)
    }

    protected fun PresentedView<presenterType, *>.bindDrawable(id: Int)
            : Lazy<PresentedView<presenterType, *>, Drawable> {
        return requiredDrawable(id, drawableFinder)
    }

    abstract val viewFinder: PresentedView<presenterType, *>.(Int) -> View?
    abstract val dimensionFinder: PresentedView<presenterType, *>.(Int) -> Int?
    abstract val stringFinder: PresentedView<presenterType, *>.(Int) -> String?
    abstract val colorFinder: PresentedView<presenterType, *>.(Int) -> Int?
    abstract val drawableFinder: PresentedView<presenterType, *>.(Int) -> Drawable?

    protected open fun loadImageIntoView(imagePath: String, targetImageView: ImageView) {
        if (!imagePath.isNullOrBlank()) {
            Picasso
                    .with(context)
                    .load(imagePath)
                    .fit()
                    .centerInside()
                    .into(targetImageView)
        }
    }
}
