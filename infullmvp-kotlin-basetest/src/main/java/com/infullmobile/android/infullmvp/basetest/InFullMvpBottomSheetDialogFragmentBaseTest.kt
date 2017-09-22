package com.infullmobile.android.infullmvp.basetest

import android.os.Bundle
import com.infullmobile.android.infullmvp.InFullMvpBottomSheetDialogFragment
import com.infullmobile.android.infullmvp.PresentedDialogView
import com.infullmobile.android.infullmvp.Presenter
import org.junit.After
import org.junit.Before
import org.robolectric.RuntimeEnvironment
import org.robolectric.shadows.support.v4.SupportFragmentController

abstract class InFullMvpBottomSheetDialogFragmentBaseTest<
        T : InFullMvpBottomSheetDialogFragment<PresenterType, PresentedViewType>,
        PresenterType : Presenter<PresentedViewType>,
        out PresentedViewType : PresentedDialogView<PresenterType>> {

    lateinit var testedFragment: T
        private set

    val testedPresenter: PresenterType
        get() = testedFragment.presenter
    val testedView: PresentedViewType
        get() = testedFragment.presentedView

    private lateinit var fragmentController: SupportFragmentController<T>

    @Before
    open fun setUp() {
        fragmentController = SupportFragmentController.of(provideFragment())
        testedFragment = fragmentController.create().get()
        substituteModules(testedFragment)
        fragmentController.start().resume().visible()
        testedFragment.setupDialog(testedFragment.onCreateDialog(Bundle()), 0)
    }

    @After
    fun tearDown() {
        fragmentController.pause().stop().destroy()
    }

    protected fun getString(stringResourceId: Int): String {
        return RuntimeEnvironment.application.resources.getString(stringResourceId)
    }

    protected abstract fun provideFragment(): T

    open fun substituteModules(fragment: T) {
        /* NO OP */
    }
}
