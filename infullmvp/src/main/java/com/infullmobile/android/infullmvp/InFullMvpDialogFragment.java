package com.infullmobile.android.infullmvp;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.View;

public abstract class InFullMvpDialogFragment <
        PresenterType extends Presenter <PresentedViewType>,
        PresentedViewType extends PresentedDialogView<PresenterType>
        > extends BottomSheetDialogFragment {

    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        injectIntoGraph();
        View rootView = View.inflate(getContext(), getPresentedView().getLayoutResId(), null);
        dialog.setContentView(rootView);
        getPresentedView().bindUiElements(dialog, getPresenter());
        getPresenter().bind(getArguments() != null ? getArguments() : new Bundle());
    }

    protected abstract PresenterType getPresenter();
    protected abstract PresentedViewType getPresentedView();
    protected abstract void injectIntoGraph();
}
