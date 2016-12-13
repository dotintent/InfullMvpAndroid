package ${relativePackage};

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.infullmobile.android.infullmvp.InFullMvpActivity;
import ${relativePackage}.di.${graphClass};

import javax.inject.Inject;

public class ${activityClass} extends InFullMvpActivity<${presenterClass}, ${viewClass}> {

    @Inject ${presenterClass} ${presenterClass?uncap_first};
    @Inject ${viewClass} ${viewClass?uncap_first};

    protected ${graphClass} ${graphClass?uncap_first};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ${graphClass?uncap_first} = new ${graphClass}(this);
    }

    @Override
    protected ${presenterClass} getPresenter() {
        return ${presenterClass?uncap_first};
    }

    @Override
    protected ${viewClass} getPresentedView() {
        return ${viewClass?uncap_first};
    }

    @Override
    protected void injectIntoGraph() {
        ${graphClass?uncap_first}.inject(this);
    }

    public static Intent getIntent(Context context) {
        return new Intent(context, ${activityClass}.class);
    }
}

