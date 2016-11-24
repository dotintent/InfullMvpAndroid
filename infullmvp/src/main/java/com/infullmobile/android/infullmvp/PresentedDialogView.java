package com.infullmobile.android.infullmvp;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.view.View;

public abstract class PresentedDialogView<PresenterType extends Presenter>
        extends PresentedView<PresenterType, Dialog> {

    private Dialog boundDialog;

    @Override
    protected void bindUiElements(@NonNull Dialog dialog, @NonNull PresenterType presenter) {
        this.boundDialog = dialog;
        this.boundPresenter = presenter;
        bindViews();
        onViewsBound();
    }

    @NonNull
    @Override
    public Context getContext() {
        throwIfUnbound();
        return boundDialog.getContext();
    }

    @NonNull
    protected Dialog getBoundDialog() {
        throwIfUnbound();
        return boundDialog;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected <T extends View> T findView(@IdRes final int resourceId) {
        return (T) boundDialog.findViewById(resourceId);
    }

    private void throwIfUnbound() {
        throw new IllegalStateException("This view should be bound to dialog first");
    }
}
