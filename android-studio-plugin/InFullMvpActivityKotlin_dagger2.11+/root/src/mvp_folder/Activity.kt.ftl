package ${relativePackage}

import android.content.Context
import android.content.Intent

import com.infullmobile.android.infullmvp.InFullMvpActivity

import dagger.android.AndroidInjection
import javax.inject.Inject

class ${activityClass} : InFullMvpActivity<${presenterClass}, ${viewClass}>() {

    @Inject lateinit var ${presenterClass?uncap_first}: ${presenterClass}
    @Inject lateinit var ${viewClass?uncap_first}: ${viewClass}

    override val presenter: ${presenterClass} get() = ${presenterClass?uncap_first}
    override val presentedView: ${viewClass} get() = ${viewClass?uncap_first}

    override fun injectIntoGraph() {
        AndroidInjection.inject(this)
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, ${activityClass}::class.java)
        }
    }
}
