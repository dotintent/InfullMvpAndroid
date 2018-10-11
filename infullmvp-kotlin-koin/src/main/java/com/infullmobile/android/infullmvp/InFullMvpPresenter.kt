package com.infullmobile.android.infullmvp

abstract class InFullMvpPresenter<VIEW : MvpView<*>>(override var view: VIEW) : MvpPresenter<VIEW> {

}