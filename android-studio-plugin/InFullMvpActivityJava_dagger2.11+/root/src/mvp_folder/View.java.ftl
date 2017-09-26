package ${relativePackage};

import android.support.annotation.LayoutRes;
import com.infullmobile.android.infullmvp.PresentedActivityView;
import ${rPackage}.R;

import javax.inject.Inject;

public class ${viewClass} extends PresentedActivityView<${presenterClass}> {

    @Inject public ${viewClass}() {
        /* empty */
    }

    @LayoutRes
    @Override
    protected int getLayoutResId() {
        return R.layout.${layoutName};
    }

    @Override
    protected void bindViews() {
        /* empty */
    }

    @Override
    public void onViewsBound() {
        /* empty */
    }
}
