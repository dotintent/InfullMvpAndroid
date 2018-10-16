package ${relativePackage}

import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import com.infullmobile.android.infullmvp.PresentedFragmentView
import ${relativePackage}.di.${scopeName}
import ${rPackage}.R

class ${viewClass}(fragment: Fragment) : PresentedFragmentView<${presenterClass}>(fragment) {

    override val scopeName = ${scopeName}
    @LayoutRes override val layoutId = R.layout.${layoutName}

    override fun onViewBound() {

    }
}
