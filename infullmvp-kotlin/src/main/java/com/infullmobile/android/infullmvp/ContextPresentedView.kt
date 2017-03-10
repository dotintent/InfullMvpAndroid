/*
 * Copyright © ${YEAR} inFullMobile. All rights reserved.
 */

package com.infullmobile.android.infullmvp

import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat

abstract class ContextPresentedView<PresenterType : Any, in PresentedViewType : Any>
    : PresentedView<PresenterType, PresentedViewType>() {

    override val dimensionFinder: PresentedView<PresenterType, *>.(Int) -> Int?
        get() = { context.resources?.getDimensionPixelSize(it) }

    override val stringFinder: PresentedView<PresenterType, *>.(Int) -> String?
        get() = { context.resources?.getString(it) }

    override val colorFinder: PresentedView<PresenterType, *>.(Int) -> Int?
        get() = { context.resources?.getInteger(it) }

    override val drawableFinder: PresentedView<PresenterType, *>.(Int) -> Drawable?
        get() = { ContextCompat.getDrawable(context, it) }

    override val integerFinder: PresentedView<PresenterType, *>.(Int) -> Int?
        get() = { id -> context.resources.getInteger(id) }

    override val fractionFinder: PresentedView<PresenterType, *>.(Int) -> Float?
        get() = { id -> context.resources.getFraction(id, 1, 1 /*Defaults*/) }

    override val parentFractionFinder: PresentedView<PresenterType, *>.(Int, Int, Int) -> Float?
        get() = { id, base, pBase -> context.resources.getFraction(id, base, pBase) }

    override val boolFinder: PresentedView<PresenterType, *>.(Int) -> Boolean?
        get() = { id -> context.resources.getBoolean(id) }
}