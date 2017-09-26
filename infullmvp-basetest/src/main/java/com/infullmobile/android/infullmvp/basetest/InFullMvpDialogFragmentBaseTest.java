package com.infullmobile.android.infullmvp.basetest;

import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import org.junit.After;
import org.junit.Before;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.support.v4.SupportFragmentController;

public abstract class InFullMvpDialogFragmentBaseTest<T extends DialogFragment> {

    private SupportFragmentController<T> fragmentController;
    private T fragment;

    @Before
    public void setUp() {
        fragmentController = SupportFragmentController.of(provideFragment());
        fragment = fragmentController.create().get();
        substituteModules(fragment);
        fragmentController.start().resume().visible();
    }

    @After
    public void tearDown() {
        fragmentController.pause().stop().destroy();
    }

    @NonNull
    protected String getString(int stringResourceId) {
        return RuntimeEnvironment.application.getResources().getString(stringResourceId);
    }

    @NonNull
    protected abstract T provideFragment();


    public T getTestedFragment() {
        return fragment;
    }

    public void substituteModules(T fragment) {
        /* NO OP */
    }
}