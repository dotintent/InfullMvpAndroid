package com.infullmobile.android.infullmvp

interface InFullMvpCustomView<out PresentedViewType : PresentedView<PresenterType>, PresenterType : InFullMvpPresenter<*>> {

    val presenter: PresenterType
    val presentedView: PresentedViewType

}