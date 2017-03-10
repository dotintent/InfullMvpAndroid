package ${relativePackage}.di;

import android.content.Context;

import ${relativePackage}.${fragmentClass};
import ${relativePackage}.${modelClass};
import ${relativePackage}.${presenterClass};
import ${relativePackage}.${viewClass};

import dagger.Module;
import dagger.Provides;

@Module
public class ${moduleClass} {

    private ${fragmentClass} fragment;

    public ${moduleClass}(${fragmentClass} fragment) {
        this.fragment = fragment;
    }

    @${scopeClass}
    @Provides
    ${viewClass} provides${viewClass}() {
        return new ${viewClass}();
    }

    @${scopeClass}
    @Provides
    public ${modelClass} provides${modelClass}() {
        return new ${modelClass}();
    }

    @${scopeClass}
    @Provides
    ${presenterClass} provides${presenterClass}(${modelClass} model,
                                                ${viewClass} view) {
        return new ${presenterClass}(model, view);
    }
}
