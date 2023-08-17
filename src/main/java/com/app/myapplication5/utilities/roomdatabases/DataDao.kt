package com.app.myapplication5.utilities.roomdatabases

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@Dao
interface DataDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(data: Data)

    @Query("SELECT * FROM dataStoreDetails")
    fun getAllUsers() : LiveData<List<Data>>

/*    @Query("SELECT * FROM dataStoreDetails")
    fun getAllUsers1() : Flow<List<Data>>*/

    @Query("SELECT * FROM dataStoreDetails WHERE id=:Id")
    fun getUsersDetailsById(Id: Int) : LiveData<Data>
}