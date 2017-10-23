package ${relativePackage}.di;

import ${relativePackage}.${fragmentClass};
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent
public interface ${componentClass} {

     @Subcomponent.Builder
     public abstract class Builder extends AndroidInjector.Builder<${fragmentClass}>{}
}
