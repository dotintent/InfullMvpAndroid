package com.infullmobile.android.infullmvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class InFullMvpFragment <
        PresenterType extends Presenter<PresentedViewType>,
        PresentedViewType extends PresentedFragmentView<PresenterType>
        > extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        injectIntoGraph();
        View rootView = inflater.inflate(getPresentedView().getLayoutResId(), container, false);
        getPresentedView().bindUiElements(rootView, getPresenter());
        Bundle bundle = getActivity().getIntent().getExtras();
        getPresenter().bind(bundle != null ? bundle : new Bundle());
        return rootView;
    }

    protected abstract PresenterType getPresenter();
    protected abstract PresentedViewType getPresentedView();
    protected abstract void injectIntoGraph();
}
