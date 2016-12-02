package com.infullmobile.android.infullmvp.basetest;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialogFragment;

import org.junit.Before;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.support.v4.SupportFragmentController;

public abstract class InFullMvpDialogFragmentBaseTest<T extends BottomSheetDialogFragment> {

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
