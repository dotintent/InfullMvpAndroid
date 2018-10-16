package com.infullmobile.android.infullmvp

import kotlinx.android.extensions.LayoutContainer

abstract class PresentedView<PresenterType : InFullMvpPresenter<*>> : MvpView, LayoutContainer {

    lateinit var presenter: PresenterType

    fun bindView(presenter: PresenterType) {
        this.presenter = presenter
        onViewBound()
    }

    abstract val scopeName: String
    abstract val layoutId: Int
}