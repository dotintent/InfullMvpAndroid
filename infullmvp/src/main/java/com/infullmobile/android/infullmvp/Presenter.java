package com.infullmobile.android.infullmvp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class Presenter <PresentedViewType extends PresentedView> {

    private final PresentedViewType presentedView;

    protected abstract void bind(@NonNull Bundle bundle);

    public Presenter(@NonNull PresentedViewType presentedView) {
        this.presentedView = presentedView;
    }

    @NonNull
    public PresentedViewType getPresentedView() {
        return presentedView;
    }

    @NonNull
    public Context getContext() {
        return presentedView.getContext();
    }

    public String getTag() {
        return getClass().getName();
    }

    protected void unbind() {
        // NO OP
    }

    protected void onResume() {
        // NO OP
    }

    protected void onPause() {
        // NO OP
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // NO OP
    }

    protected void onRequestPermissionResult(int resultCode, String[] permissions, int[] grantResult) {
        // NO OP
    }
}
