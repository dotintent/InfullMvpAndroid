package com.infullmobile.android.infullmvp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import rx.subscriptions.CompositeSubscription

abstract class Presenter<out T : PresentedView<*, *>>(val presentedView: T) {

    private val allSubscriptions = CompositeSubscription()
    protected val context: Context
        get() = presentedView.context

    val tag: String
        get() = javaClass.simpleName

    abstract fun bind(intentBundle: Bundle)

    open fun unbind() {
        allSubscriptions.unsubscribe()
    }

    fun registerSubscription(subscription: rx.Subscription) {
        allSubscriptions.add(subscription)
    }

    open fun onResume() {
        // NO OP
    }

    open fun onPause() {
        // NO OP
    }

    open fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //NO OP
    }

    open fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        //NO OP
    }
}
