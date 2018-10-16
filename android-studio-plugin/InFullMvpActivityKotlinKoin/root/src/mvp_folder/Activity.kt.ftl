package ${relativePackage}

import com.infullmobile.android.infullmvp.InFullMvpActivity
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class ${activityClass}: InFullMvpActivity<${viewClass}, ${presenterClass}>() {

    override val presenter: ${presenterClass} by inject { parametersOf(this) }
    override val presentedView: ${viewClass} by inject { parametersOf(this) }

}
