package com.infullmobile.android.infullmvp.basetest

import android.app.Activity
import com.infullmobile.android.infullmvp.InFullMvpActivity
import com.infullmobile.android.infullmvp.InFullMvpView
import com.infullmobile.android.infullmvp.PresentedCustomView
import com.infullmobile.android.infullmvp.Presenter
import org.junit.Before
import org.robolectric.Robolectric
import org.robolectric.RuntimeEnvironment
import org.robolectric.android.controller.ActivityController

abstract class InFullMvpViewBaseTest<
        T : InFullMvpView<PresenterType, PresentedViewType>,
        PresenterType : Presenter<PresentedViewType>,
        out PresentedViewType : PresentedCustomView<PresenterType>,
        ActivityType : InFullMvpActivity<*, *>
> {

    lateinit var testedCustomView: T
    val testedPresenter: PresenterType
        get() = testedCustomView.presenter
    val testedView: PresentedViewType
        get() = testedCustomView.presentedView

    abstract val activityClass: Class<ActivityType>
    lateinit var activityController: ActivityController<ActivityType>
    private lateinit var parentActivity: ActivityType

    @Before
    open fun setUp() {
        activityController = Robolectric.buildActivity(activityClass)
        parentActivity = activityController.get()
        testedCustomView = provideCustomView(parentActivity)
        substituteModules(testedCustomView)
        activityController.create().visible()
        testedCustomView.initialize() // Robolectric never calls onAttachedToWindow()
    }

    protected fun getString(stringResourceId: Int): String =
            RuntimeEnvironment.application.resources.getString(stringResourceId)

    protected abstract fun provideCustomView(parentActivity: Activity): T

    open fun substituteModules(customView: T) {
        /* NO OP */
    }
}
