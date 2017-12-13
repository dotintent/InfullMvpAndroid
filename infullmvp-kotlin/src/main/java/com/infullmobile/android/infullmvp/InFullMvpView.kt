package com.infullmobile.android.infullmvp

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout

abstract class InFullMvpView<
        PresenterType : Presenter<PresentedViewType>,
        out PresentedViewType : PresentedCustomView<PresenterType>
        >(open val parentContext: Context, attrs: AttributeSet?) : LinearLayout(parentContext, attrs) {

    constructor(parentContext: Context) : this(parentContext, null)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : this(context, attrs)

    lateinit var view: View
    abstract val presenter: PresenterType
    abstract val presentedView: PresentedViewType
    abstract fun injectIntoGraph()

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        injectIntoGraph()
        view = inflate(parentContext, presentedView.layoutResId, this)
        presentedView.bindUiElements(this, presenter)
        presenter.bind(Bundle(), Bundle(), null)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        presenter.onPause()
    }
}

