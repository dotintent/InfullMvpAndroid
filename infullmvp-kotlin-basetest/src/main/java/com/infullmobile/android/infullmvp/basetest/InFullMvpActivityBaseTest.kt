package com.infullmobile.android.infullmvp.basetest

import android.content.Intent
import com.infullmobile.android.infullmvp.InFullMvpActivity
import com.infullmobile.android.infullmvp.PresentedActivityView
import com.infullmobile.android.infullmvp.Presenter
import org.junit.After
import org.junit.Before
import org.robolectric.Robolectric
import org.robolectric.RuntimeEnvironment
import org.robolectric.android.controller.ActivityController

abstract class InFullMvpActivityBaseTest<
        T : InFullMvpActivity<PresenterType, PresentedViewType>,
        PresenterType : Presenter<PresentedViewType>,
        out PresentedViewType : PresentedActivityView<PresenterType>> {

    lateinit var testedActivity: T
        private set

    private lateinit var activityController: ActivityController<T>
    protected abstract val testActivityClass: Class<T>

    val testedPresenter: PresenterType
        get() = testedActivity.presenter
    val testedView: PresentedViewType
        get() = testedActivity.presentedView

    @Before
    open fun setUp() {
        activityController = Robolectric.buildActivity(testActivityClass).withIntent(activityIntent).create()
        testedActivity = activityController.get()
        substituteModules(testedActivity)
        activityController.start().postCreate(null).visible()
    }

    @After
    fun tearDown() {
        activityController.pause().stop().destroy()
    }

    open protected val activityIntent: Intent
        get() = Intent(RuntimeEnvironment.application, testActivityClass)

    protected fun getString(stringResourceId: Int): String {
        return RuntimeEnvironment.application.resources.getString(stringResourceId)
    }

    open fun substituteModules(activity: T) {
        /* NO OP */
    }
}
