package ${relativePackage};

import com.infullmobile.android.infullmvp.InFullMvpFragment;
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject;

public class ${fragmentClass} extends InFullMvpFragment<${presenterClass}, ${viewClass}> {

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
    protected void injectIntoGraph() {
        AndroidSupportInjection.inject(this);
    }
}

