package ${relativePackage};

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.infullmobile.android.infullmvp.Presenter;

public class ${presenterClass} extends Presenter<${viewClass}> {

    private final ${modelClass} ${modelClass?uncap_first};

    public ${presenterClass}(@NonNull ${viewClass} presentedView,
                                   @NonNull ${modelClass} ${modelClass?uncap_first}) {
        super(presentedView);
        this.${modelClass?uncap_first} = ${modelClass?uncap_first};
    }

    @Override
    protected void bind(@NonNull Bundle bundle) {

    }
}
