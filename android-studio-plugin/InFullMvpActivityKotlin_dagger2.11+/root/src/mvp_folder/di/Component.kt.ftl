package ${relativePackage}.di

import ${relativePackage}.${activityClass}
import ${relativePackage}.di.${scopeClass}
import dagger.Subcomponent
import dagger.android.AndroidInjector

import dagger.Component

@${scopeClass}
@Subcomponent
interface ${componentClass} : AndroidInjector<${activityClass}> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<${activityClass}>()
}
