package ${relativePackage}.di

import ${relativePackage}.${fragmentClass}
import dagger.Subcomponent
import dagger.android.AndroidInjector

@${scopeClass}
@Subcomponent
interface ${componentClass} : AndroidInjector<${fragmentClass}> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<${fragmentClass}>()
}
