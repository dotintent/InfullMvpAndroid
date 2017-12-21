package com.infullmobile.android.infullmvp.sample

import android.app.Activity
import android.support.v4.app.Fragment
import com.infullmobile.android.infullmvp.sample.activity.SampleActivity
import com.infullmobile.android.kotlin.navigation.InFullNavigation

open class SampleNavigation: InFullNavigation, Navigation {

    constructor(activity: Activity) : super(activity)
    constructor(activity: Activity, fragment: Fragment) : super(activity, fragment)

    override fun sampleScreen() = buildLaunchableIntent(SampleActivity.getIntent(activity))
}
