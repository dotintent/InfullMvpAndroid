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

    @Provides
    static Context providesContext(${fragmentClass} fragment) {
        return fragment.getContext();
    }

    @Provides
    static ${viewClass} provides${viewClass}() {
        return new ${viewClass}();
    }

    @Provides
    static ${modelClass} provides${modelClass}() {
        return new ${modelClass}();
    }

    @Provides
    static ${presenterClass} provides${
            presenterClass}(${modelClass} model,
            ${viewClass} view
    ) {
        return new ${presenterClass}(model, view);
    }
}
