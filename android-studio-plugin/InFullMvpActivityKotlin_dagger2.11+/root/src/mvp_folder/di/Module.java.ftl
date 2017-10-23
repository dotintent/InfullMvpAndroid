package ${relativePackage}.di;

import android.content.Context;

import ${relativePackage}.${activityClass};
import ${relativePackage}.${modelClass};
import ${relativePackage}.${presenterClass};
import ${relativePackage}.${viewClass};

import dagger.Module;
import dagger.Binds;
import dagger.Provides;

@Module
public abstract class ${moduleClass} {

    @Binds
    abstract Context bindsContext(${activityClass} activity);

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
