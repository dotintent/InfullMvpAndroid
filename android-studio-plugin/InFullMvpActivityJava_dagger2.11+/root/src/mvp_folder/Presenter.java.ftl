package ${relativePackage};

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.infullmobile.android.infullmvp.Presenter;

import javax.inject.Inject;

public class ${presenterClass} extends Presenter<${viewClass}> {

    private final ${modelClass} ${modelClass?uncap_first};

    public @Inject ${presenterClass} (
        @NonNull ${modelClass} ${modelClass?uncap_first},
        @NonNull ${viewClass} presentedView
    ) {
        super(presentedView);
        this.${modelClass?uncap_first} = ${modelClass?uncap_first};
    }

    @Override
    protected void bind(@NonNull Bundle bundle, @NonNull Bundle savedInstanceState, @Nullable Uri intentData) {
        /* empty */
    }
}
