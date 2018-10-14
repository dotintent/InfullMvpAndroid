package com.infullmobile.android.infullmvp

import android.content.Intent
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.android.scope.ext.android.bindScope
import org.koin.android.scope.ext.android.getOrCreateScope

abstract class InFullMvpFragment<out PresentedViewType : PresentedView<PresenterType>, PresenterType : InFullMvpPresenter<*>>
    : Fragment() {

    abstract val presenter: PresenterType
    abstract val view: PresentedViewType

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindScope(getOrCreateScope(view.scopeName))
    }

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(view.layoutId, container, false)
    }

    @CallSuper
    override fun onViewCreated(v: View, savedInstanceState: Bundle?) {
        super.onViewCreated(v, savedInstanceState)
        view.bindView(presenter)
        presenter.bind(arguments, savedInstanceState)
    }

    @CallSuper
    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    @CallSuper
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        presenter.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

    @CallSuper
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        presenter.onSaveInstanceState(outState)
    }

    @CallSuper
    override fun onDestroy() {
        presenter.unbind()
        super.onDestroy()
    }

}