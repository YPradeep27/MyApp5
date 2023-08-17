package com.app.myapplication5.utilities

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.app.myapplication5.BuildConfig
import com.app.myapplication5.utilities.daggerInjections.component.DaggerMyComponent
import com.app.myapplication5.utilities.daggerInjections.component.MyComponent
import com.app.myapplication5.utilities.daggerInjections.module.DaggerModule
import com.app.myapplication5.utilities.daggerInjections.module.DatabaseModule
import timber.log.Timber

class MyApplication : MultiDexApplication() {

    lateinit var myComponent: MyComponent

/*    private val appComponent: MyComponent by lazy {
        DaggerMyComponent.builder()
            .databaseModule(DatabaseModule())
            .build()
    }*/

    override fun onCreate() {
        super.onCreate()
       // appComponent.inject(this)
        myComponent = DaggerMyComponent.builder().daggerModule(
            DaggerModule(
                this
            )
        ).databaseModule(DatabaseModule()).build()




        //---------Timber object build-----------
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }
}