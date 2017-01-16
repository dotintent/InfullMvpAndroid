package com.infullmobile.android.infullmvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class InFullMvpFragment<
        PresenterType extends Presenter<PresentedViewType>,
        PresentedViewType extends PresentedFragmentView<PresenterType>
        > extends Fragment {

    protected abstract PresenterType getPresenter();
    protected abstract PresentedViewType getPresentedView();
    protected abstract void injectIntoGraph();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        injectIntoGraph();
        View rootView = inflater.inflate(getPresentedView().getLayoutResId(), container, false);
        getPresentedView().bindUiElements(rootView, getPresenter());
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getActivity().getIntent().getExtras();
        getPresenter().bind(
                bundle != null ? bundle : new Bundle(),
                savedInstanceState != null ? savedInstanceState : new Bundle(),
                getActivity().getIntent().getData()
        );
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) {
        getPresenter().saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }
}
