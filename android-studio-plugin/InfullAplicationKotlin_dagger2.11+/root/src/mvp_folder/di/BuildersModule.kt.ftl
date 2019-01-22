package ${relativePackage}.di

import dagger.Module

@Module
abstract class BuildersModule {

    // @ContributesAndroidInjector(modules = arrayOf(SomeModule::class))
    // abstract fun contributesSomeActivityConstructor(): SomeActivity
}