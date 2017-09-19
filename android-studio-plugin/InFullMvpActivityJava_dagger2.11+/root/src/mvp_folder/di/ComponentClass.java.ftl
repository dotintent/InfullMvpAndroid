package ${relativePackage}.di;

import ${relativePackage}.${activityClass};
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@${scopeClass}
@Subcomponent
public interface ${componentClass} {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<${activityClass}> {
        /* empty */
    }
}
