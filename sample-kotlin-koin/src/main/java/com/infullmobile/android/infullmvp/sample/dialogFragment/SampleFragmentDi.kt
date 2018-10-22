package com.infullmobile.android.infullmvp.sample.dialogFragment

import org.koin.dsl.module.module

const val sampleDialogFragmentScopeName = "sampleDialogFragmentScopeName"
val sampleDialogFragmentModule = module(sampleDialogFragmentScopeName) {
    factory { (fragment: SampleDialogFragment) -> SampleDialogFragmentPresenter(fragment.presentedView) }
    factory { (fragment: SampleDialogFragment) -> SampleDialogFragmentView(fragment) }
}