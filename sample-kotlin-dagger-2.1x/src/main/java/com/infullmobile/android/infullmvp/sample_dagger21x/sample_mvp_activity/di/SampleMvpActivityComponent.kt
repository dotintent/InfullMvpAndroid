package com.infullmobile.android.infullmvp.sample_dagger21x.sample_mvp_activity.di

import com.infullmobile.android.infullmvp.sample_dagger21x.sample_mvp_activity.SampleMvpActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@SampleMvpActivityScope
@Subcomponent
interface SampleMvpActivityComponent : AndroidInjector<SampleMvpActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<SampleMvpActivity>()
}
