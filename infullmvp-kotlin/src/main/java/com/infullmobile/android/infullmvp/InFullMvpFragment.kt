package com.infullmobile.android.infullmvp

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class InFullMvpFragment<
        PresenterType : Presenter<PresentedViewType>,
        out PresentedViewType : PresentedFragmentView<PresenterType>
        > : Fragment() {

    abstract val presenter: PresenterType
    abstract val presentedView: PresentedViewType

    abstract fun injectIntoGraph()

    override final fun onCreateView(inflater: LayoutInflater,
                                    container: ViewGroup?,
                                    savedInstanceState: Bundle?): View? {
        injectIntoGraph()
        val rootView = inflater.inflate(presentedView.layoutResId, container, false)
        presentedView.bindUiElements(rootView, presenter)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.bind(activity.intent.extras?: Bundle(), savedInstanceState ?: Bundle(), activity.intent.data)
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        presenter.onActivityResult(requestCode, resultCode, data)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        presenter.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        presenter.saveInstanceState(outState)
        super.onSaveInstanceState(outState)
    }
}
