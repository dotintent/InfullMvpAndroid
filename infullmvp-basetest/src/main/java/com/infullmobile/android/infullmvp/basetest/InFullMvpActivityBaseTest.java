package com.infullmobile.android.infullmvp.basetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import org.junit.Before;
import org.robolectric.Robolectric;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.util.ActivityController;

public abstract class InFullMvpActivityBaseTest<T extends AppCompatActivity> {

    private T activity;

    @Before
    public void setUp() {
        final ActivityController<T> controller = getActivity();
        activity = controller.get();
        substituteModules(activity);
        controller.postCreate(null).visible();
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
