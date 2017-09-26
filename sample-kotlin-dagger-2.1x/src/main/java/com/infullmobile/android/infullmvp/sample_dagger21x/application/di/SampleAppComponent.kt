package com.infullmobile.android.infullmvp.sample_dagger21x.application.di

import com.infullmobile.android.infullmvp.sample_dagger21x.application.SampleApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Component(
        modules = arrayOf(
                AndroidSupportInjectionModule::class,
                BuildersModule::class
        )
)
interface SampleAppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: SampleApp): Builder

        fun build(): SampleAppComponent
    }

    fun inject(app: SampleApp)

}
