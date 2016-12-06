package ${relativePackage}

import android.os.Bundle
import com.infullmobile.android.infullmvp.Presenter

open class ${presenterClass}(private val model: ${modelClass},
                              view: ${viewClass}) : Presenter<${viewClass}>(view) {

    override fun bind(intentBundle: Bundle) {

    }
}
