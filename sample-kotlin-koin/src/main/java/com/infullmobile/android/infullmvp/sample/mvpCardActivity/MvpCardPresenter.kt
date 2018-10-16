package com.infullmobile.android.infullmvp.sample.mvpCardActivity

import android.net.Uri
import android.os.Bundle
import com.infullmobile.android.infullmvp.InFullMvpPresenter

class MvpCardPresenter(view: MvpCardView)
    : InFullMvpPresenter<MvpCardView>(view) {

    override fun bind(intentBundle: Bundle, savedInstanceState: Bundle, intentData: Uri?) {

    }
}