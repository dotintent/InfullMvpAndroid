package com.infullmobile.android.infullmvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public abstract class InFullMvpActivity<
        PresenterType extends Presenter<PresentedViewType>,
        PresentedViewType extends PresentedActivityView<PresenterType>
        > extends AppCompatActivity {

    protected abstract PresenterType getPresenter();
    protected abstract PresentedViewType getPresentedView();
    protected abstract void injectIntoGraph();

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        injectIntoGraph();
        setContentView(getPresentedView().getLayoutResId());
        getPresentedView().bindUiElements(this, getPresenter());
        getPresenter().bind(
                getIntent().getExtras() != null ? getIntent().getExtras() : new Bundle(),
                savedInstanceState != null ? savedInstanceState : new Bundle(),
                getIntent().getData()
        );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getPresenter().unbind();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        getPresenter().onPause();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getPresentedView().inflateMenu(menu, getMenuInflater());
        return true;
    }

    @Override
    public final boolean onOptionsItemSelected(@Nullable MenuItem item) {
        return item != null && (getPresentedView().onOptionsItemSelected(item) || super.onOptionsItemSelected(item));
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getPresenter().onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        getPresenter().onRequestPermissionResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onBackPressed() {
        if (!getPresenter().onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        getPresenter().saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }
}
