package ${relativePackage}.di

import ${relativePackage}.${applicationClass}
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Component(
        modules = arrayOf(
                AndroidSupportInjectionModule::class,
                BuildersModule::class
        )
)
interface ${applicationClass}Component {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: ${applicationClass}): Builder

        fun build(): ${componentClass}
    }

    fun inject(app: ${applicationClass})

}
