package com.app.myapplication5.utilities.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.app.myapplication5.utilities.MyApplication
import com.app.myapplication5.utilities.daggerInjections.module.HelperSharedPreference
import com.app.myapplication5.utilities.roomdatabases.DataDao
import com.app.myapplication5.utilities.roomdatabases.UserDatabase
import javax.inject.Inject

open class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var sharedPreference: HelperSharedPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as MyApplication).myComponent.inject(this)

    }
}