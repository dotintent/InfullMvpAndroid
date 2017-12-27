package com.infullmobile.android.infullmvp.sample.mvp_card_activity

import android.content.Context
import android.content.Intent
import com.infullmobile.android.infullmvp.InFullMvpActivity
import com.infullmobile.android.infullmvp.sample.di_components.HasComponent
import com.infullmobile.android.infullmvp.sample.mvp_card_activity.di.MvpCardGraph
import com.infullmobile.android.infullmvp.sample.mvp_card_activity.di.MvpCardGraph.MvpCardComponent
import javax.inject.Inject

class MvpCardActivity :
        InFullMvpActivity<MvpCardPresenter, MvpCardView>(),
        HasComponent<MvpCardComponent> {

    @Inject lateinit var mvpCardPresenter: MvpCardPresenter
    @Inject lateinit var mvpCardView: MvpCardView
    val mvpCardGraph = MvpCardGraph(this)

    override fun injectIntoGraph() {
        mvpCardGraph.inject(this)
    }

    override val presenter: MvpCardPresenter get() = mvpCardPresenter
    override val presentedView: MvpCardView get() = mvpCardView

    override val component: MvpCardComponent
        get() = mvpCardGraph.mvpCardComponent

    companion object {
        fun getIntent(context: Context): Intent = Intent(context, MvpCardActivity::class.java)
    }
}
