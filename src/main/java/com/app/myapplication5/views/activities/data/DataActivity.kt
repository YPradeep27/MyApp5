package com.app.myapplication5.views.activities.data

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.myapplication5.R
import com.app.myapplication5.databinding.ActivityMainBinding
import com.app.myapplication5.utilities.common.BaseActivity
import com.app.myapplication5.utilities.coroutines.Coroutines
import com.app.myapplication5.utilities.extensions.isNetworkActive
import com.app.myapplication5.utilities.roomdatabases.Data
import com.app.myapplication5.viewmodels.DataViewModel
import timber.log.Timber

class DataActivity : BaseActivity() {

    lateinit var mViewModel: DataViewModel
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@DataActivity,R.layout.activity_main)

        setContentView(binding.root)
        Initialization()
        onClickListeners()
        apiObserver()



    }

    private fun apiObserver() {

        if(this.isNetworkActive()) {

            Timber.e("Check Line 44")
           // mViewModel.getData(20)
            mViewModel.getData1(20)
            Timber.e("Check Line 45")


            mViewModel.myList.observe(this@DataActivity, Observer { list ->
                if (list.isEmpty()){
                    mViewModel.apiResult?.observe(this@DataActivity, Observer {

                        Timber.e("Activity Check List : apiResult")
                        for (data in it.data){
                            val users = Data(data.id,data.avatar,data.email,data.first_name,data.last_name)
                            mViewModel.insertData(users)
                        }

                        binding.recyclerViewUsers.adapter = DataAdapter(
                            it.data
                        )
                    })
                }
                else {
                    binding.recyclerViewUsers.adapter = DataAdapter(list)
                }
            })



/*            lifecycleScope.launchWhenCreated {
                mViewModel.apiResponse.collect {

                    for (data in it){
                        for (userList in data.data){
                            val users = Data(userList.id,userList.avatar,userList.email,userList.first_name,userList.last_name)
                            mViewModel.insertData(users)
                        }

                    }

                    binding.recyclerViewUsers.adapter = DataAdapter(
                        it
                    )
                }
            }*/


            /*
            mViewModel.apiResult?.observe(this@DataActivity, Observer {

                if (it.status){
                    for (data in it.data?.data!!){
                        val data1  = Data(data.id,data.avatar,data.email,data.first_name,data.last_name)
                        mViewModel.insertData(data1)
                    }
                    binding.recyclerViewUsers.adapter = DataAdapter(
                        it.data?.data!!
                    )
                }
            })*/
        }else{


          /*  lifecycleScope.launchWhenCreated {
                mViewModel.apiResponse.collect {

                    binding.recyclerViewUsers.adapter = DataAdapter(
                        it
                    )
                }
            }*/

            mViewModel.myList.observe(this@DataActivity, Observer {
                binding.recyclerViewUsers.adapter = DataAdapter(it)
            })
        }
    }

    private fun onClickListeners() {

        binding.btnSave.setOnClickListener {
            sharedPreference.saveString("Data",binding.inputField.text.toString())
        }

        binding.btnGet.setOnClickListener {
            binding.outputField.text = sharedPreference.getString("Data")
        }

    }
    private fun Initialization() {

        mViewModel = ViewModelProvider(this@DataActivity,viewModelFactory).get(DataViewModel::class.java)
        binding.recyclerViewUsers.layoutManager = LinearLayoutManager(this)

    }
}