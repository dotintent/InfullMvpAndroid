package com.infullmobile.android.infullmvp.sample.di_components

interface HasComponent<out T> {
    val component: T
}