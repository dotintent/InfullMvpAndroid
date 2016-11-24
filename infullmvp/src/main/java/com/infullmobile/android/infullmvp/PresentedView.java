package com.infullmobile.android.infullmvp;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;

public abstract class PresentedView<PresenterType extends Presenter, ViewType> {

    protected PresenterType boundPresenter;

    @LayoutRes
    protected abstract int getLayoutResId();
    protected abstract void bindUiElements(@NonNull ViewType boundingView, @NonNull PresenterType presenter);
    protected abstract void bindViews();
    protected abstract void onViewsBound();
    protected abstract <T extends View> T findView(@IdRes int resourceId);

    @NonNull
    public abstract Context getContext();

    public void bindPresenter(@NonNull PresenterType presenter) {
        this.boundPresenter = presenter;
    }

    @NonNull
    public PresenterType getBoundPresenter() {
        return boundPresenter;
    }
}
