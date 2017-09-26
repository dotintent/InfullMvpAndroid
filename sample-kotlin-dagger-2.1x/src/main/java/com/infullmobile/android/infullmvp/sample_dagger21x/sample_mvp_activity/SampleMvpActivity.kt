package com.infullmobile.android.infullmvp.sample_dagger21x.sample_mvp_activity

import android.content.Context
import android.content.Intent
import com.infullmobile.android.infullmvp.InFullMvpActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class SampleMvpActivity : InFullMvpActivity<SampleMvpActivityPresenter, SampleMvpActivityView>() {

    @Inject lateinit var sampleMvpActivityPresenter: SampleMvpActivityPresenter
    @Inject lateinit var sampleMvpActivityView: SampleMvpActivityView

    override val presenter: SampleMvpActivityPresenter get() = sampleMvpActivityPresenter
    override val presentedView: SampleMvpActivityView get() = sampleMvpActivityView

    override fun injectIntoGraph() {
        AndroidInjection.inject(this)
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, SampleMvpActivity::class.java)
        }
    }
}
