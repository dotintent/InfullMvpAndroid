package com.infullmobile.android.infullmvp.sample.customView

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.infullmobile.android.infullmvp.inject
import com.infullmobile.android.infullmvp.sample.R
import kotlinx.android.synthetic.main.custom_view_sample.view.*
import org.koin.core.parameter.parametersOf

class CustomMvpView(context: Context, attrs: AttributeSet?)
    : FrameLayout(context, attrs), CustomMvpViewContract.View {

    private val presenter: CustomMvpViewContract.Presenter by inject { parametersOf(this) }

    init {
        inflate(context, R.layout.custom_view_sample, this)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        presenter.bind(null, null)
    }

    override fun updateText(text: String) {
        temperature.text = text
    }
}