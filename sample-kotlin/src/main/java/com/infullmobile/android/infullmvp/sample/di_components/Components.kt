package com.infullmobile.android.infullmvp.sample.di_components

class Components private constructor() {

    companion object {
        fun <T> from(activityWithComponent: HasComponent<T>): T = activityWithComponent.component
    }
}