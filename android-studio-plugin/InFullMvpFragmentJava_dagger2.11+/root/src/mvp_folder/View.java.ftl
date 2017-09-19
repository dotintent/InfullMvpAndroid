package ${relativePackage};

import android.support.annotation.LayoutRes;
import com.infullmobile.android.infullmvp.PresentedFragmentView;
import ${rPackage}.R;

public class ${viewClass} extends PresentedFragmentView<${presenterClass}> {

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
