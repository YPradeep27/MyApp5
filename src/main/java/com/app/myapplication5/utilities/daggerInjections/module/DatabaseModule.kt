package com.app.myapplication5.utilities.daggerInjections.module

import android.content.Context
import androidx.room.Room
import com.app.myapplication5.utilities.roomdatabases.DataDao
import com.app.myapplication5.utilities.roomdatabases.UserDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    fun provideDatabase(context: Context) : UserDatabase {
        return UserDatabase.getDatabase(context)

    }

    @Provides
    fun provideDao(database: UserDatabase) : DataDao{
        return database.roomDao()
    }
}