package com.infullmobile.android.infullmvp

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.widget.FrameLayout

abstract class InFullMvpView<
        PresenterType : Presenter<PresentedViewType>,
        out PresentedViewType : PresentedCustomView<PresenterType>
>(
        open val parentContext: Context,
        attrs: AttributeSet?
) : FrameLayout(parentContext, attrs) {

    constructor(parentContext: Context) : this(parentContext, null)

    abstract val presenter: PresenterType
    abstract val presentedView: PresentedViewType
    abstract fun injectIntoGraph()

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        initialize()
    }

    fun initialize() {
        injectIntoGraph()
        presentedView.bindUiElements(
                inflate(parentContext, presentedView.layoutResId, this),
                presenter
        )
        presenter.bind(Bundle(), Bundle(), null)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        presenter.unbind()
    }
}