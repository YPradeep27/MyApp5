package com.app.myapplication5.utilities.daggerInjections.module

import android.content.Context
import android.content.SharedPreferences
import com.app.myapplication5.utilities.Constants
import com.app.myapplication5.utilities.daggerInjections.annotations.scopes.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class DaggerModule(val context: Context) {

    @Provides
    @ApplicationScope
    fun provideContext() : Context {
        return context
    }

    @Provides
    @ApplicationScope
    fun provideSharedPreference() : SharedPreferences{
        return context.getSharedPreferences(Constants.Shared_Pref,Context.MODE_PRIVATE)
    }
}