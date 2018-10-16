package com.infullmobile.android.infullmvp

import android.content.Intent
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import org.koin.android.scope.ext.android.bindScope
import org.koin.android.scope.ext.android.getOrCreateScope

abstract class InFullMvpFragment<out PresentedViewType : PresentedView<PresenterType>, PresenterType : InFullMvpPresenter<*>>
    : Fragment() {

    abstract val presenter: PresenterType
    abstract val presentedView: PresentedViewType

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindScope(getOrCreateScope(presentedView.scopeName))
    }

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(presentedView.layoutId, container, false)
    }

    @CallSuper
    override fun onViewCreated(v: View, savedInstanceState: Bundle?) {
        super.onViewCreated(v, savedInstanceState)
        presentedView.bindView(presenter)
        presenter.bind(assembleBundleSum(), savedInstanceState ?: Bundle(), activity!!.intent.data)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (!checkAllKeysAreUnique()) {
            throw IllegalStateException(
                    "Bundle for your fragment cannot have the same keys as the one from your activity")
        }
        presenter.bind(assembleBundleSum(), savedInstanceState ?: Bundle(), activity?.intent?.data)
    }

    private fun checkAllKeysAreUnique(): Boolean {
        return arguments?.keySet()?.intersect(activity?.intent?.extras?.keySet() ?: emptySet())?.isEmpty() ?: true
    }

    private fun assembleBundleSum(): Bundle {
        return Bundle().apply {
            putAll(activity!!.intent.extras ?: Bundle())
            putAll(arguments ?: Bundle())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbind()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

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

    override fun onSaveInstanceState(outState: Bundle) {
        presenter.onSaveInstanceState(outState)
        super.onSaveInstanceState(outState)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return presenter.onContextItemSelected(item) ||  super.onContextItemSelected(item)
    }

}