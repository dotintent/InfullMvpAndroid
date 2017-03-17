package com.infullmobile.android.infullmvp

import android.app.Activity
import android.content.Intent
import android.support.v4.app.Fragment

open class LaunchableIntent {

    private val activity: Activity
    private val intent: Intent
    private val fragment: Fragment?

    constructor(activity: Activity, intent: Intent) :this(activity, intent, null)

    constructor(activity: Activity, intent: Intent, fragment: Fragment?) {
        this.activity = activity
        this.intent = intent
        this.fragment = fragment
    }

    open fun start() {
        fragment?.startActivity(intent) ?: activity.startActivity(intent)
    }

    open fun startAndFinishCurrent() {
        start()
        activity.finish()
    }

    open fun startForResult(requestCode: Int) {
        fragment?.startActivityForResult(intent, requestCode) ?: activity.startActivityForResult(intent, requestCode)
    }
}
