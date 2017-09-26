package ${relativePackage}.di;

import ${relativePackage}.${fragmentClass};
import ${relativePackage}.${modelClass};
import ${relativePackage}.${presenterClass};
import ${relativePackage}.${viewClass};

import android.content.Context;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class ${moduleClass} {

    private ${fragmentClass} fragment;

    @${scopeClass}
    @Binds
    abstract ${moduleClass} bindsFragment(${fragmentClass} fragment);

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
    public static ${modelClass} provides${modelClass}() {
        return new ${modelClass}();
    }

    @${scopeClass}
    @Provides
    static ${presenterClass} provides${presenterClass}(
            ${viewClass} view,
            ${modelClass} model
    ) {
        return new ${presenterClass}(view, model);
    }
}
