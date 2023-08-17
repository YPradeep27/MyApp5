package com.app.myapplication5.utilities.common

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.myapplication5.utilities.common.pojo.ApiStatus
import com.app.myapplication5.utilities.retrofit.RetrofitService
import com.app.myapplication5.utilities.roomdatabases.DataDao
import com.app.myapplication5.utilities.roomdatabases.UserDatabase
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import javax.inject.Inject

open class BaseViewModel : ViewModel() {

    @Inject
    lateinit var dataDao: DataDao

    protected val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    @Inject
    lateinit var retrofitService: RetrofitService


    /*   @Inject
       lateinit var userDatabase: UserDatabase*/

    val loader : MutableLiveData<Boolean> = MutableLiveData()
    val apiStatus : MutableLiveData<ApiStatus> = MutableLiveData()
    var compositeDisposable : CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()

        compositeDisposable.clear()
        viewModelScope.cancel()
    }
}