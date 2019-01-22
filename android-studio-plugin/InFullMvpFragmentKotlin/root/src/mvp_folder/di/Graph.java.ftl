package ${relativePackage}.di;

import android.support.annotation.VisibleForTesting;

import ${relativePackage}.${fragmentClass};
<#if useApplicationComponent>
import ${appComponentPackage}.di.ApplicationComponent;
import ${appComponentPackage}.di.Components;
</#if>

import dagger.Component;

public class ${graphClass} {

    private final Dagger${graphClass}_${componentClass}.Builder builder;

    public ${graphClass}(${fragmentClass} fragment) {
        this.builder = Dagger${graphClass}_${componentClass}
                .builder()
                <#if useApplicationComponent>
                .applicationComponent(Components.from(fragment.getActivity().getApplication()))
                </#if>
                .${moduleClass?uncap_first}(new ${moduleClass}(fragment));
    }

    public void inject(${fragmentClass} fragment) {
        builder.build().inject(fragment);
    }

    @VisibleForTesting
    public void set${moduleClass}(${moduleClass} module) {
        builder.${moduleClass?uncap_first}(module);
    }

    @Component(
        <#if useApplicationComponent>
        dependencies = ApplicationComponent.class,
        </#if>
        modules = ${moduleClass}.class
    )
    public interface ${componentClass} {
        void inject(${fragmentClass} fragment);
    }
}
