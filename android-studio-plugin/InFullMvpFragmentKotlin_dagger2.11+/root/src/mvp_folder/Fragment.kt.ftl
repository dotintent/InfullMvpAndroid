package ${relativePackage}

import android.content.Context
import android.content.Intent

import com.infullmobile.android.infullmvp.InFullMvpFragment

import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class ${fragmentClass} : InFullMvpFragment<${presenterClass}, ${viewClass}>() {

    @Inject lateinit var ${presenterClass?uncap_first}: ${presenterClass}
    @Inject lateinit var ${viewClass?uncap_first}: ${viewClass}

    override val presenter: ${presenterClass} get() = ${presenterClass?uncap_first}
    override val presentedView: ${viewClass} get() = ${viewClass?uncap_first}

    override fun injectIntoGraph() {
        AndroidSupportInjection.inject(this)
    }
}
