package ${relativePackage}

import android.os.Bundle
import com.infullmobile.android.infullmvp.InFullMvpFragment
import ${relativePackage}.di.${graphClass}
import javax.inject.Inject

class ${fragmentClass} : InFullMvpFragment<${presenterClass}, ${viewClass}>() {

    @Inject lateinit var ${presenterClass?uncap_first}: ${presenterClass}
    @Inject lateinit var ${viewClass?uncap_first}: ${viewClass}
    lateinit var ${graphClass?uncap_first}: ${graphClass}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ${graphClass?uncap_first} = ${graphClass}(this)
    }

    override fun injectIntoGraph() {
        ${graphClass?uncap_first}.inject(this)
    }

    override val presenter: ${presenterClass} get() = ${presenterClass?uncap_first}
    override val presentedView: ${viewClass} get() = ${viewClass?uncap_first}
}
