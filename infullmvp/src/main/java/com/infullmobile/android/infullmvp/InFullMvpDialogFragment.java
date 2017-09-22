package com.infullmobile.android.infullmvp;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v4.app.DialogFragment;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public abstract class InFullMvpDialogFragment<
        PresenterType extends Presenter<PresentedViewType>,
        PresentedViewType extends PresentedDialogView<PresenterType>
        > extends DialogFragment {

    protected abstract PresenterType getPresenter();

    protected abstract PresentedViewType getPresentedView();

    protected abstract void injectIntoGraph();

    @Override
    public void setupDialog(Dialog dialog, int style) {
        unrestrictedSetup(dialog, style);
        injectIntoGraph();
        final View rootView = View.inflate(getContext(), getPresentedView().getLayoutResId(), null);
        dialog.setContentView(rootView);
        getPresentedView().bindUiElements(dialog, getPresenter());
        getPresenter().bind(
                getArguments() != null ? getArguments() : new Bundle(),
                new Bundle(),
                getActivity().getIntent().getData()
        );
    }

    /**
     * {@code android.support.v4.app.DialogFragment.setupDialog(Dialog, int)}
     * <p>method is group restricted via</p>
     * {@code @hide @RestrictTo(LIBRARY_GROUP) }
     * It will fail on lint. Code is being copied from the super class
     */
    void unrestrictedSetup(Dialog dialog, int style) {
        switch (style) {
            case STYLE_NO_INPUT:
                final Window dialogWindow = dialog.getWindow();
                if (dialogWindow != null) {
                    dialogWindow.addFlags(NO_INPUT_FLAGS);
                }
                // fall through...
            case STYLE_NO_FRAME:
            case STYLE_NO_TITLE:
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
    }

    private static final int NO_INPUT_FLAGS =
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;

    @Override
    public boolean onContextItemSelected(final MenuItem item) {
        return getPresenter().onContextItemSelected(item) || super.onContextItemSelected(item);
    }
}
