package com.app.myapplication5.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.myapplication5.DataPOJO
import com.app.myapplication5.models.DataModel
import com.app.myapplication5.utilities.common.BaseViewModel
import com.app.myapplication5.utilities.coroutines.Coroutines
import com.app.myapplication5.utilities.roomdatabases.Data
import com.app.myapplication5.utilities.roomdatabases.UserDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class DataViewModel
@Inject
constructor(private val dataModel: DataModel, private val userDatabase2: UserDatabase) : BaseViewModel() {

    var apiResult : MutableLiveData<DataPOJO>? = MutableLiveData()
    var apiResponse = MutableStateFlow<List<DataPOJO>>(emptyList())


    var myList: LiveData<List<Data>>
   // var mySecondList : Flow<List<Data>>

    init {
        dataDao = userDatabase2.roomDao()
        myList =dataDao.getAllUsers()
      //  mySecondList =dataDao.getAllUsers1()

    }


    fun getData(size : Int){
        viewModelScope.launch {

            try {
                Timber.e("Get Data Try: ${dataModel.getUsersData(size)}")
                apiResponse.value = dataModel.getUsersData(size)

            } catch (e: Exception) {

                Timber.e("Get Data Catch : ${e}")

                // Handle error
            }
           // apiResult?.value = dataModel.getUsersData(size)

        }
    }

    fun getData1(size : Int){
        Coroutines.main {

            apiResult?.value = dataModel.getUsersData1(size)
/*
            try {
                Timber.e("Get Data Try Live : ${retrofitService.getUsers(size)}")
                apiResult?.value = dataModel.getUsersData1(size)

            } catch (e: Exception) {

                Timber.e("Get Data Catch Live : ${e}")

                // Handle error
            }*/
            //

        }
    }

    fun insertData(user: Data) {

        Coroutines.main {
            dataDao.insertUser(user)
        }
    }

    fun fetch(): LiveData<List<Data>> {
        return myList
    }


}