package com.infullmobile.android.infullmvp;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public abstract class PresentedActivityView<PresenterType extends Presenter>
        extends PresentedView<PresenterType, InFullMvpActivity> {

    private InFullMvpActivity presentedActivity;

    @Override
    protected void bindUiElements(@NonNull InFullMvpActivity boundingActivity, @NonNull PresenterType presenter) {
        this.presentedActivity = boundingActivity;
        this.boundPresenter = presenter;
        bindViews();
        onViewsBound();
    }

    @NonNull
    @Override
    public Context getContext() {
        throwIfUnbound();
        return presentedActivity;
    }

    @Nullable
    @SuppressWarnings("UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
    public final ActionBar getActionBar() {
        throwIfUnbound();
        return presentedActivity.getSupportActionBar();
    }

    @SuppressWarnings("UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
    protected final void setActionBar(@NonNull Toolbar toolbar) {
        throwIfUnbound();
        presentedActivity.setSupportActionBar(toolbar);
    }

    @SuppressWarnings({"unchecked", "UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR"})
    protected <ViewType extends View> ViewType findView(@IdRes int resourceId) {
        return (ViewType) presentedActivity.findViewById(resourceId);
    }

    private void throwIfUnbound() {
        if (presentedActivity == null) {
            throw new IllegalStateException("This view must be bound to activity first");
        }
    }

    protected void inflateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        // NO OP
    }

    protected boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
