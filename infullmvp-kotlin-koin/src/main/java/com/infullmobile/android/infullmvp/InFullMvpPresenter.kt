package com.infullmobile.android.infullmvp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem

abstract class InFullMvpPresenter<PresentedView : MvpView>(var view: PresentedView) {

    abstract fun bind(intentBundle: Bundle, savedInstanceState: Bundle, intentData: Uri?)

    open fun unbind() {
        /* No OP */
    }

    open fun onResume() {
        /* NO OP */
    }

    open fun onPause() {
        /* NO OP */
    }

    open fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        /* NO OP */
    }

    open fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        /* NO OP */
    }

    open fun onBackPressed(): Boolean {
        return false
    }

    open fun onSaveInstanceState(outState: Bundle) {
        /* NO OP */
    }

    open fun onContextItemSelected(item: MenuItem): Boolean {
        return false
    }
}