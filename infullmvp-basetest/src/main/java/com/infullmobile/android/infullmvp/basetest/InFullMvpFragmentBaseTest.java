package com.infullmobile.android.infullmvp.basetest;

import android.support.annotation.NonNull;

import com.infullmobile.android.infullmvp.InFullMvpFragment;

import org.junit.Before;
import org.robolectric.shadows.support.v4.SupportFragmentController;

public abstract class InFullMvpFragmentBaseTest<T extends InFullMvpFragment> {

    private T fragment;

    @Before
    public void setUp() {
        SupportFragmentController<T> fragmentController
                = SupportFragmentController.of(provideFragment());
        fragment = fragmentController.create().get();
        substituteModules(fragment);
        fragmentController.start().resume().visible();
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
