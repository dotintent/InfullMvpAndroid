package com.infullmobile.android.infullmvp.sample.application

import android.app.Application
import com.infullmobile.android.infullmvp.inject
import com.infullmobile.android.infullmvp.sample.activity.sampleKoinActivityModule
import com.infullmobile.android.infullmvp.sample.dialogFragment.sampleDialogFragmentModule
import com.infullmobile.android.infullmvp.sample.mvpCardActivity.sampleActivity2Module
import com.infullmobile.android.infullmvp.sample.temperatureCard.temperatureCardModule
import com.infullmobile.android.infullmvp.sample.fragment.sampleFragmentModule
import com.infullmobile.android.infullmvp.sample.models.SharedPreferencesModel
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.module

val allModules = listOf(
        module {
            single { SharedPreferencesModel(get()) }
        },
        sampleKoinActivityModule,
        sampleActivity2Module,
        sampleFragmentModule,
        temperatureCardModule,
        sampleDialogFragmentModule
)

class SampleApplication : Application() {

    private val sharedPreferencesModel: SharedPreferencesModel by inject()

    override fun onCreate() {
        super.onCreate()
        startKoin(this, allModules)

        sharedPreferencesModel.welcomeText = "MVP SAMPLE SHARED PREFS INJECTED TEXT"
    }
}