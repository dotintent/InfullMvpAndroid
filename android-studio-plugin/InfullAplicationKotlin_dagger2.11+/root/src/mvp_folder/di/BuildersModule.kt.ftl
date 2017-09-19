package ${relativePackage}.di

import dagger.Module

@Module
abstract class BuildersModule {

    // @SomeScope
    // @ContributesAndroidInjector(modules = arrayOf(SomeModule::class))
    // abstract fun contributesSomeScopeActivityConstructor(): SomeScopeActivity
}