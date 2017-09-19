package ${relativePackage}

import android.os.Bundle
import android.net.Uri
import com.infullmobile.android.infullmvp.Presenter

import javax.inject.Inject

class ${presenterClass} @Inject constructor(
    private val model: ${modelClass},
    view: ${viewClass}
) : Presenter<${viewClass}>(view) {

    override fun bind(intentBundle: Bundle, savedInstanceState: Bundle, intentData: Uri?) {
        /* empty */
    }
}
