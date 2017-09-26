package ${relativePackage};

import android.content.Context;
import android.content.Intent;

import com.infullmobile.android.infullmvp.InFullMvpActivity;

import dagger.android.AndroidInjection;
import javax.inject.Inject;

public class ${activityClass} extends InFullMvpActivity<${presenterClass}, ${viewClass}> {

    @Inject ${presenterClass} ${presenterClass?uncap_first};
    @Inject ${viewClass} ${viewClass?uncap_first};

    @Override
    public ${presenterClass} getPresenter() {
        return ${presenterClass?uncap_first};
    }

    @Override
    public ${viewClass} getPresentedView() {
        return ${viewClass?uncap_first};
    }

    @Override
    public void injectIntoGraph() {
        AndroidInjection.inject(this);
    }

    public static Intent getIntent(Context context) {
        return new Intent(context, ${activityClass}.class);
    }
}

