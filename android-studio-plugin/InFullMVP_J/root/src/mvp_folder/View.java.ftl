package ${relativePackage};

import android.support.annotation.LayoutRes;
import com.infullmobile.android.infullmvp.PresentedActivityView;
import ${rPackage}.R;

public class ${viewClass} extends PresentedActivityView<${presenterClass}> {

    @LayoutRes
    @Override
    protected int getLayoutResId() {
        return R.layout.${layoutName};
    }

    @Override
    protected void bindViews() {

    }

    @Override
    public void onViewsBound() {

    }
}
