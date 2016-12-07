package com.infullmobile.android.infullmvp.basetest

import com.infullmobile.android.infullmvp.InFullMvpFragment
import com.infullmobile.android.infullmvp.PresentedFragmentView
import com.infullmobile.android.infullmvp.Presenter

import org.junit.Before
import org.robolectric.RuntimeEnvironment
import org.robolectric.shadows.support.v4.SupportFragmentController

abstract class InFullMvpFragmentBaseTest<T : InFullMvpFragment<*, *>> {

    lateinit var testedFragment: T
        private set

    val testedPresenter: Presenter<*>
        get() = testedFragment.presenter
    val testedView: PresentedFragmentView<*>
        get() = testedFragment.presentedView

    @Before
    open fun setUp() {
        val fragmentController = SupportFragmentController.of(provideFragment())
        testedFragment = fragmentController.create().get()
        substituteModules(testedFragment)
        fragmentController.start().resume().visible()
    }

    protected fun getString(stringResourceId: Int): String {
        return RuntimeEnvironment.application.resources.getString(stringResourceId)
    }

    protected abstract fun provideFragment(): T

    open fun substituteModules(fragment: T) {
        /* NO OP */
    }
}
