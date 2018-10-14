package com.infullmobile.android.infullmvp

import android.content.Intent
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v7.app.AppCompatActivity
import org.koin.android.scope.ext.android.bindScope
import org.koin.android.scope.ext.android.getOrCreateScope

abstract class InFullMvpActivity<out PresentedViewType : PresentedView<PresenterType>, PresenterType : InFullMvpPresenter<*>>
    : AppCompatActivity() {

    abstract val presenter: PresenterType
    abstract val view: PresentedViewType

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.layoutId)
        bindScope(getOrCreateScope(view.scopeName))
        view.bindView(presenter)
        presenter.bind(intent.extras, savedInstanceState)
    }

    @CallSuper
    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    @CallSuper
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        presenter.onSaveInstanceState(outState)
    }

    @CallSuper
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        presenter.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

    @CallSuper
    override fun onDestroy() {
        presenter.unbind()
        super.onDestroy()
    }
}