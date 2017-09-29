package com.infullmobile.android.infullmvp.sample_dagger21x.application

import android.app.Activity
import android.app.Application
import com.infullmobile.android.infullmvp.sample_dagger21x.application.di.DaggerSampleAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject
import android.support.v4.app.Fragment as SupportFragment

class SampleApp : Application(), HasActivityInjector, HasSupportFragmentInjector {

    @Inject lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
    @Inject lateinit var dispatchingSupportFragmentInjector: DispatchingAndroidInjector<SupportFragment>

    override fun onCreate() {
        super.onCreate()
        DaggerSampleAppComponent.builder()
                .application(this)
                .build()
                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector
    override fun supportFragmentInjector(): AndroidInjector<SupportFragment> = dispatchingSupportFragmentInjector

}