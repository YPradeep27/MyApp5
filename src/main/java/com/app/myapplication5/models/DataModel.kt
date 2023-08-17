package com.app.myapplication5.models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.app.myapplication5.DataPOJO
import com.app.myapplication5.utilities.Constants
import com.app.myapplication5.utilities.common.pojo.ValidationStatus
import com.app.myapplication5.utilities.coroutines.Coroutines
import com.app.myapplication5.utilities.retrofit.APIHelper
import com.app.myapplication5.utilities.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import java.util.*
import javax.inject.Inject

class DataModel
@Inject
constructor(val retrofitService: RetrofitService) {

    var status: ValidationStatus = ValidationStatus()

/*    @Inject
    lateinit var apiHelper: APIHelper*/

    suspend fun getUsersData(size : Int) : List<DataPOJO> {

        Timber.e("Data : ${size}")


        return retrofitService.getUsers(size)

    }

    suspend fun getUsersData1(size : Int) : DataPOJO {

        Timber.e("Data : ${size}")


        return retrofitService.getUsers1(size)

    }

/*    fun getUsers(data: MutableLiveData<DataPOJO>, size: Int): MutableLiveData<DataPOJO> {
        apiHelper.enqueueWithRetry(retrofitService.getUsers(
            size
        ), Constants.RETRY_COUNT, object :
            Callback<DataPOJO> {
            override fun onResponse(call: Call<DataPOJO>, response: Response<DataPOJO>) {
                Log.e("Data3",response.body()!!.message.toString())

                data.value = response.body()!!
            }

            override fun onFailure(call: Call<DataPOJO>, t: Throwable) {


                val mStatus =
                    DataPOJO()
                mStatus.status = false
                mStatus.message = "Something went wrong! Please try again later."
                Log.e("Data4","Failure")

                data.value = mStatus
            }
        })
        return data
    }*/
}