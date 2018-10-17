package com.infullmobile.android.infullmvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashSet;
import java.util.Set;

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
        if (!checkAllKeysAreUnique()) {
            throw new IllegalStateException(
                    "Bundle for your fragment cannot have the same keys as the one from your activity");
        }
        getPresenter().bind(
                assembleBundleSum(),
                savedInstanceState != null ? savedInstanceState : new Bundle(),
                getActivity().getIntent().getData()
        );
    }

    private Boolean checkAllKeysAreUnique() {
        Set<String> intersectionSet;
        if (getArguments() == null || getActivity().getIntent().getExtras() == null) {
            return true;
        }
        intersectionSet = new HashSet<>(getArguments().keySet());
        intersectionSet.retainAll(getActivity().getIntent().getExtras().keySet());
        return intersectionSet.isEmpty();
    }

    private Bundle assembleBundleSum() {
        Bundle sumBundle = new Bundle();
        if (getActivity().getIntent().getExtras() != null) {
            sumBundle.putAll(getActivity().getIntent().getExtras());
        }
        if (getArguments() != null) {
            sumBundle.putAll(getArguments());
        }
        return sumBundle;
    }

    @Override
    public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getPresenter().onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(final int requestCode,
                                           @NonNull final String[] permissions,
                                           @NonNull final int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        getPresenter().onRequestPermissionResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) {
        getPresenter().saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onContextItemSelected(final MenuItem item) {
        return getPresenter().onContextItemSelected(item) || super.onContextItemSelected(item);
    }
}
