package com.app.myapplication5.utilities.daggerInjections.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.myapplication5.utilities.common.ViewModelFactory
import com.app.myapplication5.utilities.daggerInjections.annotations.ViwModelKey
import com.app.myapplication5.viewmodels.DataViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViwModelKey(DataViewModel::class)
    abstract fun bindsDataViewModel(viewModel: DataViewModel) : ViewModel

    @Binds
    abstract fun bindsViewModelFactory(viewModelFactory: ViewModelFactory) : ViewModelProvider.Factory

}