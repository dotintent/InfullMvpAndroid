package com.infullmobile.android.infullmvp

import android.content.Intent
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import org.koin.android.scope.ext.android.bindScope
import org.koin.android.scope.ext.android.getOrCreateScope

abstract class InFullMvpActivity<out PresentedViewType : PresentedView<PresenterType>, PresenterType : InFullMvpPresenter<*>>
    : AppCompatActivity() {

    abstract val presenter: PresenterType
    abstract val presentedView: PresentedViewType

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(presentedView.layoutId)
        bindScope(getOrCreateScope(presentedView.scopeName))
        presentedView.bindView(presenter)
        presenter.bind(
                if (intent.extras != null) intent.extras else Bundle(),
                savedInstanceState ?: Bundle(),
                intent.data
        )
    }

    @CallSuper
    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    @CallSuper
    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        presenter.onActivityResult(requestCode, resultCode, data)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        presenter.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onBackPressed() {
        if (!presenter.onBackPressed()) {
            super.onBackPressed()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        presenter.onSaveInstanceState(outState)
        super.onSaveInstanceState(outState)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return presenter.onContextItemSelected(item) || super.onContextItemSelected(item)
    }
}