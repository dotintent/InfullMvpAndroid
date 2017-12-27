package com.infullmobile.android.infullmvp.sample.mvp_card_activity

import android.net.Uri
import android.os.Bundle
import com.infullmobile.android.infullmvp.Presenter

open class MvpCardPresenter(
        view: MvpCardView
) : Presenter<MvpCardView>(view) {

    override fun bind(intentBundle: Bundle, savedInstanceState: Bundle, intentData: Uri?) {
        /* NO OP */
    }
}