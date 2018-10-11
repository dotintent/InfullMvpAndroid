package com.infullmobile.android.infullmvp.sample.activity

import android.content.Intent
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.infullmobile.android.infullmvp.InFullMvpActivity
import com.infullmobile.android.infullmvp.sample.R
import com.infullmobile.android.infullmvp.sample.activity2.SampleActivity2
import com.infullmobile.android.infullmvp.sample.fragment.SampleFragment
import kotlinx.android.synthetic.main.activity_sample.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class SampleActivity : InFullMvpActivity<SampleActivityContract.View, SampleActivityContract.Presenter>(), SampleActivityContract.View {
    override val scopeName: String = sampleActivityScopeName
    override val presenter: SampleActivityContract.Presenter by inject { parametersOf(this) }
    override val layoutId = R.layout.activity_sample

    override fun onViewBound() {
        showCustomView.setOnClickListener {
            presenter.openCustomViewActivity()
        }
        pagesContainer.adapter = ItemsAdapter(supportFragmentManager, listOf("Fragment 1", "Fragment 2"))
    }

    override fun updateText(text: String) {
        textContainer.text = text
    }

    override fun openSample2() {
        startActivity(Intent(this, SampleActivity2::class.java))
    }

    class ItemsAdapter(fm: FragmentManager, private val items: List<String>) : FragmentStatePagerAdapter(fm) {

        override fun getItem(position: Int) = SampleFragment.newInstance(items[position])

        override fun getCount() = items.size

        override fun getPageTitle(position: Int) = items[position]
    }
}