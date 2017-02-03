package com.infullmobile.android.infullmvp

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle

abstract class Presenter<out PresentedViewType : PresentedView<*, *>>(val presentedView: PresentedViewType) {

    protected val context: Context
        get() = presentedView.context

    val tag: String
        get() = javaClass.simpleName

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

    open fun saveInstanceState(outState: Bundle) {
        /* NO OP */
    }
}
