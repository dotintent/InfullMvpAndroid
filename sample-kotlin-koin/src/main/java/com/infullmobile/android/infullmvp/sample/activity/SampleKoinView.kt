package com.infullmobile.android.infullmvp.sample.activity

import android.content.Intent
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.infullmobile.android.infullmvp.PresentedActivityView
import com.infullmobile.android.infullmvp.inject
import com.infullmobile.android.infullmvp.sample.R
import com.infullmobile.android.infullmvp.sample.dialogFragment.SampleDialogFragment
import com.infullmobile.android.infullmvp.sample.mvpCardActivity.MvpCardActivity
import kotlinx.android.synthetic.main.activity_sample.*
import org.koin.core.parameter.parametersOf

class SampleKoinView(activity: AppCompatActivity) : PresentedActivityView<SampleKoinPresenter>(activity) {
    override val scopeName = "sampleKoinActivityScopeName"
    override val layoutId = R.layout.activity_sample

    private val twoPagesAdapter: TwoSimplePagesAdapter by inject { parametersOf(context) }
    private val dialogFragment: SampleDialogFragment by inject { parametersOf(context) }
    private val fragmentManager: FragmentManager by inject { parametersOf(context) }

    override fun onViewBound() {
        showCustomView.setOnClickListener {
            presenter.openCustomViewActivity()
        }
        showDialog.setOnClickListener {
            dialogFragment.show(fragmentManager, "Dialog")
        }
        pagesContainer.adapter = twoPagesAdapter
    }

    fun updateText(text: String) {
        textContainer.text = text
    }

    fun openMvpCardActivity() {
        context.startActivity(Intent(context, MvpCardActivity::class.java))
    }
}