package com.infullmobile.android.infullmvp.sample.temperatureCard

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.infullmobile.android.infullmvp.InFullMvpCustomView
import com.infullmobile.android.infullmvp.inject
import com.infullmobile.android.infullmvp.sample.R
import org.koin.core.parameter.parametersOf

class TemperatureCard(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs),
        InFullMvpCustomView<TemperatureCardView, TemperatureCardPresenter> {

    override val presenter: TemperatureCardPresenter by inject { parametersOf(this) }
    override val view: TemperatureCardView by inject { parametersOf(this) }

    init {
        inflate(context, R.layout.custom_view_sample, this)
        view.bindView(presenter)
        presenter.bind(null, null)
    }

}