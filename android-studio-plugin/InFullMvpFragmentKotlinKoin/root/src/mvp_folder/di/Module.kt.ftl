package ${relativePackage}.di;

import android.support.v4.app.Fragment
import org.koin.dsl.module.module

import ${relativePackage}.${fragmentClass};
import ${relativePackage}.${modelClass};
import ${relativePackage}.${presenterClass};
import ${relativePackage}.${viewClass};

const val ${scopeName} = "${scopeName}"
val ${moduleName} = module(${scopeName}) {
    factory { (fragment: ${fragmentClass}) -> ${presenterClass}(get(), fragment.presentedView) }
    factory { (fragment: Fragment) -> ${viewClass}(fragment) }
    single { ${modelClass}() }
}