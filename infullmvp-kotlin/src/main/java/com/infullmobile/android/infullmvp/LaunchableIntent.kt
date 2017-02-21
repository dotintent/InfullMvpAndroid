package com.infullmobile.android.infullmvp

import android.app.Activity
import android.content.Intent
import com.infullmobile.android.infullmvp.requestcodes.FibonacciRequestCodes
import com.infullmobile.android.infullmvp.requestcodes.RequestCodeProvider

open class LaunchableIntent(private val activity: Activity,
                            private val intent: Intent) {

    open var requestCodeProvider: RequestCodeProvider<String> = DEFAULT_REQUEST_CODE_PROVIDER

    private val innerProvider: RequestCodeProvider<String>
        get() = requestCodeProvider

    val requestCode: Int = innerProvider.requestCodeFor(this.intent.component.className)

    open fun start() {
        activity.startActivity(intent)
    }

    open fun startAndFinishCurrent() {
        activity.startActivity(intent)
        activity.finish()
    }

    open fun startForResult(requestCode: Int) {
        activity.startActivityForResult(intent, requestCode)
    }

    open fun codeMatch(requestCode: Int): Boolean = this.requestCode == requestCode

    fun resultCanceled(requestCode: Int, resultCode: Int): Boolean {
        return codeMatch(requestCode) && resultCode == Activity.RESULT_CANCELED
    }

    fun codeMatchAndOk(requestCode: Int, resultCode: Int): Boolean {
        return codeMatch(requestCode) && resultCode == Activity.RESULT_OK
    }

    companion object {
        @JvmField val DEFAULT_REQUEST_CODE_PROVIDER = FibonacciRequestCodes()
    }
}
