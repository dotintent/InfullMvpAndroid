package ${relativePackage};

import android.os.Bundle;

import com.infullmobile.android.infullmvp.InFullMvpFragment;
import ${relativePackage}.di.${graphClass};

import javax.inject.Inject;

public class ${fragmentClass} extends InFullMvpFragment<${presenterClass}, ${viewClass}> {

    @Inject ${presenterClass} ${presenterClass?uncap_first};
    @Inject ${viewClass} ${viewClass?uncap_first};

    protected ${graphClass} ${graphClass?uncap_first};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ${graphClass?uncap_first} = new ${graphClass}(this);
    }

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
        ${graphClass?uncap_first}.inject(this);
    }
}

