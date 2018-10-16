package ${relativePackage}

import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import com.infullmobile.android.infullmvp.PresentedActivityView
import ${relativePackage}.di.${scopeName}
import ${rPackage}.R

class ${viewClass}(activity: AppCompatActivity) : PresentedActivityView<${presenterClass}>(activity) {

    override val scopeName = ${scopeName}
    @LayoutRes override val layoutId = R.layout.${layoutName}

    override fun onViewBound() {

    }
}
