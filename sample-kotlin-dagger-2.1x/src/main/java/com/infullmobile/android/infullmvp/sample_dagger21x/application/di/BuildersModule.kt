package com.infullmobile.android.infullmvp.sample_dagger21x.application.di

import com.infullmobile.android.infullmvp.sample_dagger21x.sample_mvp_activity.SampleMvpActivity
import com.infullmobile.android.infullmvp.sample_dagger21x.sample_mvp_activity.di.SampleMvpActivityModule
import com.infullmobile.android.infullmvp.sample_dagger21x.sample_mvp_activity.di.SampleMvpActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {

    @SampleMvpActivityScope
    @ContributesAndroidInjector(modules = arrayOf(SampleMvpActivityModule::class))
    abstract fun contributesSampleActivityConstructor(): SampleMvpActivity
}