package com.app.myapplication5.utilities.daggerInjections.component

import com.app.myapplication5.utilities.MyApplication
import com.app.myapplication5.utilities.common.BaseActivity
import com.app.myapplication5.utilities.common.BaseFragment
import com.app.myapplication5.utilities.daggerInjections.annotations.scopes.ApplicationScope
import com.app.myapplication5.utilities.daggerInjections.module.DaggerModule
import com.app.myapplication5.utilities.daggerInjections.module.DatabaseModule
import com.app.myapplication5.utilities.daggerInjections.module.RetrofitModule
import com.app.myapplication5.utilities.daggerInjections.module.ViewModelModule
import dagger.Component

@ApplicationScope
@Component(modules = [DaggerModule::class,RetrofitModule::class, ViewModelModule::class,DatabaseModule::class])
interface MyComponent {

    fun inject(activity : BaseActivity)
    fun inject(fragment: BaseFragment)
}