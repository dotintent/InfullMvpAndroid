package ${relativePackage}

import android.app.Activity
import android.app.Application
import ${relativePackage}.di.Dagger${componentClass}
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
<#if addDispatchingFragmentInjector>
import android.app.Fragment
import dagger.android.HasFragmentInjector
</#if>
<#if addDispatchingSupportFragmentInjector>
import dagger.android.support.HasSupportFragmentInjector
import android.support.v4.app.Fragment as SupportFragment
</#if>
import javax.inject.Inject

class ${applicationClass} : Application(), HasActivityInjector<#if addDispatchingFragmentInjector>, HasFragmentInjector</#if><#if addDispatchingSupportFragmentInjector>, HasSupportFragmentInjector</#if>  {

    @Inject lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>
    <#if addDispatchingFragmentInjector>
    @Inject lateinit var dispatchingFragmentInjector: DispatchingAndroidInjector<Fragment>
    </#if>
    <#if addDispatchingSupportFragmentInjector>
    @Inject lateinit var dispatchingSupportFragmentInjector: DispatchingAndroidInjector<SupportFragment>
    </#if>

    override fun onCreate() {
        super.onCreate()
        Dagger${componentClass}.builder()
                .application(this)
                .build()
                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector
    <#if addDispatchingFragmentInjector>

    override fun fragmentInjector(): AndroidInjector<Fragment> = dispatchingFragmentInjector
    </#if>
    <#if addDispatchingSupportFragmentInjector>

    override fun supportFragmentInjector(): AndroidInjector<SupportFragment> = dispatchingSupportFragmentInjector
    </#if>

}