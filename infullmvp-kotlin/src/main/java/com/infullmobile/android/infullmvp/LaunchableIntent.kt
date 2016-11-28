package com.infullmobile.android.infullmvp

import android.app.Activity
import android.content.Intent

open class LaunchableIntent(private val activity: Activity,
                            private val intent: Intent) {

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
}
