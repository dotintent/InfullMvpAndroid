package ${relativePackage}.di;

import org.koin.dsl.module.module
import android.support.v7.app.AppCompatActivity

import ${relativePackage}.${activityClass};
import ${relativePackage}.${modelClass};
import ${relativePackage}.${presenterClass};
import ${relativePackage}.${viewClass};

const val ${scopeName} = "${scopeName}"
val ${moduleName} = module(${scopeName}) {
    factory { (activity: ${activityClass}) -> ${presenterClass}(get(), activity.presentedView) }
    factory { (activity: AppCompatActivity) -> ${viewClass}(activity) }
    single { ${modelClass}() }
}
