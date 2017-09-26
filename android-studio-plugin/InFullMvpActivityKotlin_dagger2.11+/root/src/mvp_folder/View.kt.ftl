package ${relativePackage}

import android.support.annotation.LayoutRes
import com.infullmobile.android.infullmvp.PresentedActivityView
import ${rPackage}.R

import javax.inject.Inject

class ${viewClass} @Inject constructor(
): PresentedActivityView<${presenterClass}>() {

    @LayoutRes override val layoutResId = R.layout.${layoutName}

    override fun onViewsBound() {
        /* empty */
    }
}
