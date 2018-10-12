package com.infullmobile.android.infullmvp

import android.content.Intent
import android.os.Bundle

abstract class InFullMvpPresenter<VIEW : MvpView>(var view: VIEW) {

    open fun onResume() {

    }

    open fun onPageShow() {

    }

    open fun bind(extras: Bundle?, savedInstanceState: Bundle?) {

    }

    open fun unbind() {

    }

    open fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

    }

    fun onSaveInstanceState(outState: Bundle) {

    }
}