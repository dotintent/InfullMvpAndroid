package com.infullmobile.android.infullmvp.basetest

import android.content.Intent

import com.infullmobile.android.infullmvp.InFullMvpActivity
import com.infullmobile.android.infullmvp.PresentedActivityView
import com.infullmobile.android.infullmvp.Presenter

import org.junit.Before
import org.robolectric.Robolectric
import org.robolectric.RuntimeEnvironment
import org.robolectric.util.ActivityController

abstract class InFullMvpActivityBaseTest<T : InFullMvpActivity<*, *>> {

    lateinit var testedActivity: T
        private set

    val testedPresenter: Presenter<*>
        get() = testedActivity.presenter
    val testedView: PresentedActivityView<*>
        get() = testedActivity.presentedView

    @Before
    fun setUp() {
        val controller = activity
        testedActivity = controller.get()
        substituteModules(testedActivity)
        controller.postCreate(null).visible()
    }

    private val activity: ActivityController<T>
        get() = Robolectric.buildActivity(testActivityClass).withIntent(activityIntent).create()

    protected abstract val testActivityClass: Class<T>

    protected val activityIntent: Intent
        get() = Intent(RuntimeEnvironment.application, testActivityClass)

    open fun substituteModules(activity: T) {
        /* NO OP */
    }
}
