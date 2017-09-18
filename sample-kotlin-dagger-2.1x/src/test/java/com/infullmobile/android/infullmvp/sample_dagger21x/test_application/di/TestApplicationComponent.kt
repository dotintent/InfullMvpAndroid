package com.infullmobile.android.infullmvp.sample_dagger21x.test_application.di

import com.infullmobile.android.infullmvp.sample_dagger21x.test_application.TestApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Component(
        modules = arrayOf(
                AndroidSupportInjectionModule::class,
                TestBuildersModule::class
        )
)
interface TestApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: TestApplication): Builder

        fun build(): TestApplicationComponent
    }

    fun inject(app: TestApplication)

}
