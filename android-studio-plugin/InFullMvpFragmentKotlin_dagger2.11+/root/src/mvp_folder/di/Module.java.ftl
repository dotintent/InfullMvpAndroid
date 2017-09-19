package ${relativePackage}.di;

import android.content.Context;

import ${relativePackage}.${fragmentClass};
import ${relativePackage}.${modelClass};
import ${relativePackage}.${presenterClass};
import ${relativePackage}.${viewClass};

import dagger.Module;
import dagger.Provides;

@Module
public abstract class ${moduleClass} {

    @${scopeClass}
    @Provides
    static Context providesContext(${fragmentClass} fragment) {
        return fragment.getContext();
    }

    @${scopeClass}
    @Provides
    static ${viewClass} provides${viewClass}() {
        return new ${viewClass}();
    }

    @${scopeClass}
    @Provides
    static public ${modelClass} provides${modelClass}() {
        return new ${modelClass}();
    }

    @${scopeClass}
    @Provides
    static ${presenterClass} provides${
            presenterClass}(${modelClass} model,
            ${viewClass} view
    ) {
        return new ${presenterClass}(model, view);
    }
}
