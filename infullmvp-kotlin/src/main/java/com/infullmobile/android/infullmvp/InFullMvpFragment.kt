package com.infullmobile.android.infullmvp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class InFullMvpFragment<K : Presenter<T>, out T : PresentedFragmentView<K>> : Fragment() {

    override final fun onCreateView(inflater: LayoutInflater,
                                    container: ViewGroup?,
                                    savedInstanceState: Bundle?): View? {
        injectIntoGraph()
        val rootView = inflater.inflate(presentedView.layoutResId, container, false)
        presentedView.bindUiElements(rootView, presenter)
        presenter.bind(activity.intent.extras?: Bundle())
        return rootView
    }

    override final fun onDestroy() {
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

    abstract val presenter: K
    abstract val presentedView: T
    abstract fun injectIntoGraph()
}
