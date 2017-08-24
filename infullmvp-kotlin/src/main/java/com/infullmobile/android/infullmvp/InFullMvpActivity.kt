package com.infullmobile.android.infullmvp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

abstract class InFullMvpActivity<
        PresenterType : Presenter<PresentedViewType>,
        out PresentedViewType : PresentedActivityView<PresenterType>
        > : AppCompatActivity() {

    abstract val presenter: PresenterType
    abstract val presentedView: PresentedViewType

    abstract fun injectIntoGraph()

    override final fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        injectIntoGraph()
        setContentView(presentedView.layoutResId)
        presentedView.bindUiElements(this, presenter)
        presenter.bind(intent.extras?: Bundle(), savedInstanceState?: Bundle(), intent.data)
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        presentedView.inflateMenu(menu, menuInflater)
        return true
    }

    final override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return presentedView.onOptionsItemSelected(item) || super.onOptionsItemSelected(item)
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
        presenter.saveInstanceState(outState)
        super.onSaveInstanceState(outState)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        return presenter.onContextItemSelected(item) ||  super.onContextItemSelected(item)
    }
}
