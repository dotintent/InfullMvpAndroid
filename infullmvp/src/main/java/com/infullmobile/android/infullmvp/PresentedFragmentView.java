package com.infullmobile.android.infullmvp;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.view.View;

public abstract class PresentedFragmentView<PresenterType extends Presenter>
        extends PresentedView<PresenterType, View> {

    private View fragmentRootView;

    @Override
    protected void bindUiElements(@NonNull View fragmentRootView, @NonNull PresenterType presenter) {
        this.fragmentRootView = fragmentRootView;
        this.boundPresenter = presenter;
        bindViews();
        onViewsBound();
    }

    @NonNull
    @Override
    @edu.umd.cs.findbugs.annotations.SuppressWarnings("UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
    public Context getContext() {
        throwIfUnbound();
        return fragmentRootView.getContext();
    }

    @Override
    @SuppressWarnings("unchecked")
    @edu.umd.cs.findbugs.annotations.SuppressWarnings("UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
    protected <ViewType extends View> ViewType findView(@IdRes final int resourceId) {
        return (ViewType) fragmentRootView.findViewById(resourceId);
    }

    private void throwIfUnbound() {
        if (fragmentRootView == null) {
            throw new IllegalStateException("This view must be bound to fragment first.");
        }
    }
}
