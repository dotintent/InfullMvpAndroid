package com.infullmobile.android.infullmvp

import android.content.Intent
import android.os.Bundle

abstract class InFullMvpPresenter<PresentedView : MvpView>(var view: PresentedView) {

    open fun onResume() {

    }

    open fun bind(extras: Bundle?, savedInstanceState: Bundle?) {

    }

    open fun unbind() {

    }

    open fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

    }

    open fun onSaveInstanceState(outState: Bundle) {

    }
}