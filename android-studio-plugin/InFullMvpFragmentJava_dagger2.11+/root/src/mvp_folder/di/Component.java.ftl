package ${relativePackage}.di;

import ${relativePackage}.${fragmentClass};
import ${relativePackage}.di.${scopeClass};
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@${scopeClass}
@Subcomponent
public interface ${componentClass} {

     @Subcomponent.Builder
     public abstract class Builder extends AndroidInjector.Builder<${fragmentClass}>{}
}
