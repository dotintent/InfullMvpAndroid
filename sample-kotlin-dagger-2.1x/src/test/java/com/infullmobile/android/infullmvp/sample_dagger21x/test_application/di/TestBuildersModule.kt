package com.infullmobile.android.infullmvp.sample_dagger21x.test_application.di

import com.infullmobile.android.infullmvp.sample_dagger21x.sample_mvp_activity.SampleMvpActivity
import com.infullmobile.android.infullmvp.sample_dagger21x.sample_mvp_activity.di.SampleMvpActivityScope
import com.infullmobile.android.infullmvp.sample_dagger21x.sample_mvp_activity.di.SampleTestMvpActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TestBuildersModule {

    @SampleMvpActivityScope
    @ContributesAndroidInjector(modules = arrayOf(SampleTestMvpActivityModule::class))
    abstract fun contributesSomeScopeActivityConstructor(): SampleMvpActivity
}