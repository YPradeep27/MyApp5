package com.app.myapplication5.utilities.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object Coroutines {

    fun main(work : suspend (()-> Unit)){
        CoroutineScope(Dispatchers.Main).launch {
            work()
        }
    }
}