package com.infullmobile.android.kotlin.navigation

import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager

open class LaunchableBottomSheet(
        private val fragment: DialogFragment,
        private val fragmentManager: FragmentManager
) {

    open fun show() {
        fragment.show(fragmentManager, fragment.tag)
    }
}
