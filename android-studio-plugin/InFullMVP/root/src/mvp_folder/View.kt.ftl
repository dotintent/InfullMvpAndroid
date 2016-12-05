package ${relativePackage}

import android.support.annotation.LayoutRes
import com.infullmobile.android.infullmvp.PresentedActivityView
import ${rPackage}.R

open class ${viewClass}()
    : PresentedActivityView<${presenterClass}>() {

    @LayoutRes override val layoutResId = R.layout.${layoutName}

    override fun onViewsBound() {

    }
}
