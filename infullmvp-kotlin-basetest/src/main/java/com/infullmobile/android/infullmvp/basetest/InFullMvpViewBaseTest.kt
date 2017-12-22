package com.infullmobile.android.infullmvp.basetest

import android.app.Activity
import com.infullmobile.android.infullmvp.InFullMvpView
import com.infullmobile.android.infullmvp.PresentedCustomView
import com.infullmobile.android.infullmvp.Presenter
import org.junit.Before
import org.robolectric.Robolectric
import org.robolectric.RuntimeEnvironment

abstract class InFullMvpViewBaseTest<
        CustomMvpViewType : InFullMvpView<PresenterType, PresentedViewType>,
        PresenterType : Presenter<PresentedViewType>,
        out PresentedViewType : PresentedCustomView<PresenterType>
> {

    lateinit var testedCustomView: CustomMvpViewType
    val testedPresenter: PresenterType
        get() = testedCustomView.presenter
    val testedView: PresentedViewType
        get() = testedCustomView.presentedView

    abstract val activityClass: Class<out Activity>
    private lateinit var parentActivity: Activity

    @Before
    open fun setUp() {
        val activityController = Robolectric.buildActivity(activityClass)
        parentActivity = activityController.get()
        testedCustomView = provideCustomView(parentActivity)
        substituteModules(testedCustomView)
        activityController.create().visible()
        testedCustomView.initialize() // Robolectric never calls onAttachedToWindow()
    }

    protected fun getString(stringResourceId: Int): String =
            RuntimeEnvironment.application.resources.getString(stringResourceId)

    protected abstract fun provideCustomView(parentActivity: Activity): CustomMvpViewType

    open fun substituteModules(customView: CustomMvpViewType) {
        /* NO OP */
    }
}
