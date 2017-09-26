package ${relativePackage}.di;

import android.support.annotation.VisibleForTesting;

import ${relativePackage}.${activityClass};
<#if useApplicationComponent>
import ${appComponentPackage}.di.ApplicationComponent;
import ${appComponentPackage}.di.Components;
</#if>

import dagger.Component;

public class ${graphClass} {

    private final Dagger${graphClass}_${componentClass}.Builder builder;

    public ${graphClass}(${activityClass} activity) {
        this.builder = Dagger${graphClass}_${componentClass}
                .builder()
                .${moduleClass?uncap_first}(new ${moduleClass}(activity));
    }

    public void inject(${activityClass} activity) {
        builder.build()
                <#if useApplicationComponent>
                .applicationComponent(Components.from(activity.getApplication()))
                </#if>
                .inject(activity);
    }

    @VisibleForTesting
    public void set${moduleClass}(${moduleClass} module) {
        builder.${moduleClass?uncap_first}(module);
    }

    @${scopeClass}
    @Component(
        <#if useApplicationComponent>
        dependencies = ApplicationComponent.class,
        </#if>
        modules = ${moduleClass}.class
    )
    public interface ${componentClass} {
        void inject(${activityClass} activity);
    }
}
