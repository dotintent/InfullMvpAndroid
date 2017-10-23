package ${relativePackage}.di

import ${relativePackage}.${activityClass}
import dagger.Subcomponent
import dagger.android.AndroidInjector

import dagger.Component

@Subcomponent
interface ${componentClass} : AndroidInjector<${activityClass}> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<${activityClass}>()
}
