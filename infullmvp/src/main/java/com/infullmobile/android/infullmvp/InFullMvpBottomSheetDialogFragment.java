package com.infullmobile.android.infullmvp;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.MenuItem;
import android.view.View;

public abstract class InFullMvpBottomSheetDialogFragment<
        PresenterType extends Presenter<PresentedViewType>,
        PresentedViewType extends PresentedDialogView<PresenterType>
        > extends BottomSheetDialogFragment {

    protected abstract PresenterType getPresenter();

    protected abstract PresentedViewType getPresentedView();

    protected abstract void injectIntoGraph();

    @CallSuper
    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        injectIntoGraph();
        dialog.setContentView(
                View.inflate(getContext(), getPresentedView().getLayoutResId(), null)
        );
        getPresentedView().bindUiElements(dialog, getPresenter());
        getPresenter().bind(
                getArguments() != null ? getArguments() : new Bundle(),
                new Bundle(),
                getActivity().getIntent().getData()
        );
    }

    @Override
    public boolean onContextItemSelected(final MenuItem item) {
        return getPresenter().onContextItemSelected(item) || super.onContextItemSelected(item);
    }
}
