package ${relativePackage}

import android.support.annotation.LayoutRes
import com.infullmobile.android.infullmvp.PresentedFragmentView
import ${rPackage}.R

open class ${viewClass}()
    : PresentedFragmentView<${presenterClass}>() {

    @LayoutRes override val layoutResId = R.layout.${layoutName}

    override fun onViewsBound() {

    }
}
