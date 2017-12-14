package com.infullmobile.android.infullmvp.basetest

import android.app.Activity
import android.view.LayoutInflater
import com.infullmobile.android.infullmvp.InFullMvpView
import com.infullmobile.android.infullmvp.PresentedCustomView
import com.infullmobile.android.infullmvp.Presenter
import org.junit.After
import org.junit.Before
import org.robolectric.Robolectric
import org.robolectric.RuntimeEnvironment
import org.robolectric.android.controller.ActivityController

abstract class InFullMvpCustomViewBaseTest
<T : InFullMvpView<PresenterType, PresentedViewType>,
        PresenterType : Presenter<PresentedViewType>,
        out PresentedViewType : PresentedCustomView<PresenterType>> {

    lateinit var testedCustomView: T

    abstract val layoutResId: Int

    val testedPresenter: PresenterType
        get() = testedCustomView.presenter
    val testedView: PresentedViewType
        get() = testedCustomView.presentedView

    protected lateinit var activityController: ActivityController<Activity>

    @Before
    open fun setUp() {
        activityController = Robolectric.buildActivity(Activity::class.java)
        testedCustomView = LayoutInflater.from(activityController.get()).inflate(
                layoutResId,
                null
        ) as T
        substituteModules(testedCustomView)
    }

    @After
    fun tearDown() {
        activityController.pause().stop().destroy()
    }

    protected fun getString(stringResourceId: Int): String {
        return RuntimeEnvironment.application.resources.getString(stringResourceId)
    }

    protected abstract fun provideCustomView(): T

    open fun substituteModules(customView: T) {
        /* NO OP */
    }
}
