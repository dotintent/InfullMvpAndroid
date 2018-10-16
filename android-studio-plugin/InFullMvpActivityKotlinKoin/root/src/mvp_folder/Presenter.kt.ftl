package ${relativePackage}

import android.os.Bundle
import com.infullmobile.android.infullmvp.InFullMvpPresenter

open class ${presenterClass}(private val model: ${modelClass},
                             view: ${viewClass}) : InFullMvpPresenter<${viewClass}>(view) {

    override fun bind(intentBundle: Bundle, savedInstanceState: Bundle, intentData: Uri?) {

    }
}