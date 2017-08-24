package com.infullmobile.android.infullmvp.basetest;

import android.content.Intent;
import com.infullmobile.android.infullmvp.InFullMvpActivity;
import com.infullmobile.android.infullmvp.PresentedActivityView;
import com.infullmobile.android.infullmvp.Presenter;
import org.junit.After;
import org.junit.Before;
import org.robolectric.Robolectric;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.android.controller.ActivityController;

public abstract class InFullMvpActivityBaseTest<
        T extends InFullMvpActivity<PresenterType, PresentedViewType>,
        PresenterType extends Presenter<PresentedViewType>,
        PresentedViewType extends PresentedActivityView<PresenterType>> {

    private ActivityController<T> controller;
    private T activity;

    @edu.umd.cs.findbugs.annotations.SuppressWarnings("UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
    public PresenterType getPresenter() {
        return activity.getPresenter();
    }

    @edu.umd.cs.findbugs.annotations.SuppressWarnings("UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
    public PresentedViewType getPresentedView() {
        return activity.getPresentedView();
    }

    @Before
    public void setUp() {
        controller = getActivity();
        activity = controller.get();
        substituteModules(activity);
        controller.postCreate(null).visible();
    }

    @After
    public void tearDown() {
        controller.pause().stop().destroy();
    }

    public T getTestedActivity() {
        return activity;
    }

    private ActivityController<T> getActivity() {
        return Robolectric.buildActivity(getTestActivityClass()).withIntent(getActivityIntent()).create();
    }

    protected abstract Class<T> getTestActivityClass();

    protected Intent getActivityIntent() {
        return new Intent(RuntimeEnvironment.application, getTestActivityClass());
    }

    public void substituteModules(T activity) {
        /* NO OP */
    }
}
